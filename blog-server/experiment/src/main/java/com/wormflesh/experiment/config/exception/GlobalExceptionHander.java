package com.wormflesh.experiment.config.exception;

import com.wormflesh.experiment.config.result.Result;
import com.wormflesh.experiment.config.result.ResultMsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: wormflesh
 * @Date: Created in 11:03 2022/3/16
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHander {

    @ExceptionHandler(Exception.class)
    public Result Execption(Exception e) {
        log.error("未知异常！", e);
        return Result.error(ResultMsgEnum.SERVER_BUSY.getCode(),ResultMsgEnum.SERVER_BUSY.getMessage());
    }
}
