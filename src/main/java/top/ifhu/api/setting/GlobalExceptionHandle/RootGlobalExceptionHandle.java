package top.ifhu.api.setting.GlobalExceptionHandle;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.ifhu.api.setting.ResponseTemplateConfig.ResponseTemplate;
import top.ifhu.api.setting.ResponseTemplateConfig.ReturnCode;

@RestControllerAdvice(annotations = RestController.class)
public class RootGlobalExceptionHandle {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseTemplate handleNoHandlerFoundException( NoHandlerFoundException e ){
        return ResponseTemplate.fail(ReturnCode.UNDEINED_INTERFACE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseTemplate handleDefaultException(Exception e)  {

        return ResponseTemplate.fail(ReturnCode.RC500);
    }
}
