package com.sample.demo.service;

import com.sample.demo.dao.entity.DataEntity;
import com.sample.demo.dao.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    /**
     * 核心检证方法：在一个事务中更新 SCHEMA_A 和 SCHEMA_B 的数据
     *
     * @param id         数据 ID
     * @param newStatus  新状态
     * @param shouldFail 是否故意抛出异常以触发回滚
     * @return 事务结果信息
     */
    @Transactional
    public String performCrossSchemaUpdate(boolean shouldFail1, boolean shouldFail2) {

        DateTimeFormatter dtf =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

        // 1. 更新 Schema A 的表
        int rowsA = transactionMapper.updateTableAStatus(1, "newStatus" + LocalDateTime.now().format(dtf));
        // 3. 事务一致性验证点：如果 shouldFail 为 true，则抛出运行时异常，
        //    Spring 的 @Transactional 会捕获并触发 ROLLBACK。
        if (shouldFail1) {
            throw new RuntimeException("Validation failure: Intentionally rolling back the transaction.");
        }

        // 2. 更新 Schema B 的表 (跨 Schema 操作)
        int rowsB = transactionMapper.updateTableBStatus(1, "newStatus" + LocalDateTime.now().format(dtf));

        // 3. 事务一致性验证点：如果 shouldFail 为 true，则抛出运行时异常，
        //    Spring 的 @Transactional 会捕获并触发 ROLLBACK。
        if (shouldFail2) {
            throw new RuntimeException("Validation failure: Intentionally rolling back the transaction.");
        }

        return "";
    }


    public List<DataEntity> checkStatusA() {
        return transactionMapper.getTableAStatus();
    }

    public List<DataEntity> checkStatusB() {
        return transactionMapper.getTableBStatus();
    }

}