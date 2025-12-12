package com.sample.demo.service;

import com.sample.demo.dao.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    /**
     * 核心检证方法：在一个事务中更新 SCHEMA_A 和 SCHEMA_B 的数据
     * @param id 数据 ID
     * @param newStatus 新状态
     * @param shouldFail 是否故意抛出异常以触发回滚
     * @return 事务结果信息
     */
    @Transactional
    public String performCrossSchemaUpdate(int id, String newStatus, boolean shouldFail) {
        // 1. 更新 Schema A 的表
        int rowsA = transactionMapper.updateTableAStatus(id, newStatus);

        // 2. 更新 Schema B 的表 (跨 Schema 操作)
        int rowsB = transactionMapper.updateTableBStatus(id, newStatus);

        // 3. 事务一致性验证点：如果 shouldFail 为 true，则抛出运行时异常，
        //    Spring 的 @Transactional 会捕获并触发 ROLLBACK。
        if (shouldFail) {
            throw new RuntimeException("Validation failure: Intentionally rolling back the transaction.");
        }

        return String.format("Transaction SUCCESS. Rows updated: SCHEMA_A=%d, SCHEMA_B=%d. Expected status: %s",
                rowsA, rowsB, newStatus);
    }

    public String checkStatus(int id) {
        String statusA = transactionMapper.getTableAStatus(id);
        String statusB = transactionMapper.getTableBStatus(id);
        return String.format("Current Status: SCHEMA_A = %s, SCHEMA_B = %s", statusA, statusB);
    }
}