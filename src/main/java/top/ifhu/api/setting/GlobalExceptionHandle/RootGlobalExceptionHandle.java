package top.ifhu.api.setting.GlobalExceptionHandle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.ifhu.api.setting.ResponseTemplateConfig.ResponseTemplate;
import top.ifhu.api.setting.ResponseTemplateConfig.ReturnCode;

@Slf4j
@Order(1)
@RestControllerAdvice(annotations = RestController.class)
public class RootGlobalExceptionHandle {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseTemplate handleNoHandlerFoundException( NoHandlerFoundException e ){
        return ResponseTemplate.fail(ReturnCode.UNDEINED_INTERFACE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseTemplate handleDefaultException(Exception e)  {
        log.info("默认消息"+e.getMessage());
        return ResponseTemplate.fail(ReturnCode.RC500);
    }
}
