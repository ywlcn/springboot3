package com.sample.common.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogServletRequestListener implements ServletRequestListener {

    private static final Logger logger = LoggerFactory.getLogger(LogServletRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.warn("LogServletRequestListener--->requestInitialized : {} [{}]", sre , sre.getServletRequest().getRequestId());
        // リクエスト開始時の処理を行う。
        // (実装は省略)
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.warn("LogServletRequestListener--->requestDestroyed : {} [{}]", sre , sre.getServletRequest().getRequestId());
        // リクエスト終了時の処理を行う。
        // (実装は省略)
    }

}