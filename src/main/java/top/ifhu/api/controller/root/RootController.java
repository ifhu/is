package top.ifhu.api.controller.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class RootController {
    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String hello(){
        return "Hello,Spring!" + session.getId() + System.currentTimeMillis();
    }
}
