package com.sample.demo.controller;

import com.sample.demo.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    private final TransactionService transactionService;

    public WebController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * 渲染主表单页面，并获取当前数据状态
     * URL: /
     */
    @GetMapping("/")
    public String index(Model model) {
        // 1. 获取当前状态并添加到模型
        String statusMessage = transactionService.checkStatus(1);
        model.addAttribute("currentStatus", statusMessage);

        // 2. 准备表单数据
        model.addAttribute("id", 1);
        model.addAttribute("status", "NEW_STATUS_" + System.currentTimeMillis());

        return "transaction-form"; // 对应 src/main/resources/templates/transaction-form.html
    }

    /**
     * 处理事务提交操作 (COMMIT 或 ROLLBACK)
     * URL: /perform
     */
    @PostMapping("/perform")
    public String performTransaction(
            @RequestParam("id") int id,
            @RequestParam("status") String status,
            @RequestParam("action") String action, // 区分 commit/rollback
            RedirectAttributes redirectAttributes) {

        boolean shouldFail = "ROLLBACK".equalsIgnoreCase(action);
        String resultMessage;

        try {
            resultMessage = transactionService.performCrossSchemaUpdate(id, status, shouldFail);
            if (shouldFail) {
                // 如果预期失败，但代码中捕获了异常，这里是回滚成功
                resultMessage = "Transaction ROLLBACK SUCCESS: Data should be unchanged. " + resultMessage;
            }
            redirectAttributes.addFlashAttribute("successMessage", resultMessage);
        } catch (RuntimeException e) {
            // 捕获到业务逻辑中抛出的回滚异常
            resultMessage = "Transaction ROLLBACK EXPECTED and Fired: " + e.getMessage();
            redirectAttributes.addFlashAttribute("errorMessage", resultMessage);
        } catch (Exception e) {
            // 其他意外错误
            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
        }

        // 重定向到主页，使用 Flash 属性显示消息
        return "redirect:/";
    }
}