package com.sample.demo.controller;

import com.sample.demo.dao.entity.DataEntity;
import com.sample.demo.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {

    private final TransactionService transactionService;

    public WebController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/")
    public String index(Model model) {
        // 1. 获取当前状态并添加到模型
        List<DataEntity> a = transactionService.checkStatusA();
        List<DataEntity> b = transactionService.checkStatusA();

        model.addAttribute("tableA", a.getFirst());
        model.addAttribute("tableB", b.getFirst());

        return "transaction-form"; // 对应 src/main/resources/templates/transaction-form.html
    }

    /**
     * 处理事务提交操作 (COMMIT 或 ROLLBACK)
     * URL: /perform
     */
    @PostMapping("/perform")
    public String performTransaction(
            Model model,
            @RequestParam("action") String action, // 区分 commit/rollback
            RedirectAttributes redirectAttributes) {

        String resultMessage;

        try {

            if ("ROLLBACK1".equals(action)) {
                resultMessage = transactionService.performCrossSchemaUpdate(true, false);

            } else if ("ROLLBACK2".equals(action)) {
                resultMessage = transactionService.performCrossSchemaUpdate(true, true);

            } else {
                resultMessage = transactionService.performCrossSchemaUpdate(false, false);
            }

            redirectAttributes.addFlashAttribute("successMessage", resultMessage);
        } catch (RuntimeException e) {
            e.printStackTrace();
            // 捕获到业务逻辑中抛出的回滚异常
            resultMessage = "Transaction ROLLBACK EXPECTED and Fired: " + e.getMessage();
            redirectAttributes.addFlashAttribute("errorMessage", resultMessage);
        } catch (Exception e) {
            e.printStackTrace();
            // 其他意外错误
            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
        }

        return index(model);
    }
}