package top.ifhu.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ifhu.api.setting.ResponseTemplateConfig.ResponseTemplate;
import top.ifhu.api.setting.ResponseTemplateConfig.ReturnCode;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;


@RestController
public class NotFoundErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseTemplate undefinedApi(HttpServletRequest request) {
        return ResponseTemplate.fail(
                ReturnCode.UNDEINED_INTERFACE);
    }
}
