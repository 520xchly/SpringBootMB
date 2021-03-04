package com.vsofo.cspcommon.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Mvc 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class MvcGloabExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity<ErrorInfo> handleAllExceptions(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        log.error("全局异常：" + "(" + ex.getMessage() + ")", ex);
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorInfo(500, ex.getMessage()));
    }

    @Data
    class ErrorInfo {
        private long code;
        private String message;

        public ErrorInfo(long code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
