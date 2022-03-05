package top.ifhu.api.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.Attribute;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private HttpSession session;
    @GetMapping("/me")
    public  String showMe(){
        Object count =  session.getAttribute("count");
        if(count == null){
            session.setAttribute("count",1);
        }else{
            int d = Integer.valueOf((String) count);
            session.setAttribute("count",++d );
        }
        return "会话" + session.getId() + "点击次数" + count;
    }


}
