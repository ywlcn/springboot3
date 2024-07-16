package com.sample.demo.controller;

import com.sample.dto.DemoErrorResponse;
import com.sample.dto.User;
import com.sample.graphql.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/user")
public class RestNormalController {

    Logger loger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/getNormal")
    public List<User> getNormal() {
        int i = 0;
        i = 12 / i;
        return userService.findALl();
    }

    @RequestMapping("/getCallable")
    public Callable<List<User>> getCallable() {
        return () -> {
            int i = 0;
            i = 12 / i;
            return userService.findALl();
        };
    }

    @Autowired
    ExecutorService executorService;

    @RequestMapping("/getCompletableFuture")
    public CompletableFuture<List<User>> getCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
            return userService.findALl();
        }, executorService);
    }

    @RequestMapping("/getDeferredResult")
    public DeferredResult<List<User>> getDeferredResult() {

        // 1. タイムアウト時に返す値を用意する
        DeferredResult<List<User>> deferredResult = new DeferredResult<>(10000L, new ArrayList<User>());

        // 2. 正常終了時の処理を登録する
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                // DeferredResult#setResult()が呼ばれた場合に、ここが実行される
            }
        });

        // 3. タイムアウト時の処理を登録する
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                // タイムアウトした場合に、ここが実行される
            }
        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                // 4. 戻り値はDeferredResult#setResult()にセットする
                deferredResult.setResult(userService.findALl());
            }
        };
        thread.start();
        return deferredResult;
    }

    @RequestMapping("/geterror")
    public Callable<List<User>> throwError() {
        throw new RuntimeException("aaaaa");
    }

//    @ExceptionHandler(Exception.class)
//    public DemoErrorResponse handleException(Exception exception) {
//        return new DemoErrorResponse(exception);
//    }


}