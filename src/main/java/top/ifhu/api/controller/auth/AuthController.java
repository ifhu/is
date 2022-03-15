package top.ifhu.api.controller.auth;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.ifhu.api.controller.auth.verifyCode.VerifyCode;
import top.ifhu.api.controller.auth.verifyCode.VerifyCodeGenerate;
import top.ifhu.api.controller.auth.verifyCode.VerifyCodeTool;
import top.ifhu.api.dao.entity.UserAccountModel;
import top.ifhu.api.dao.repo.UserAccountRepository;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@Api("用户认证")
public class AuthController {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private HttpSession session;

    @PostMapping("/login")
    public boolean login(){

        return false;
    }
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public UserAccountModel registerUserAccount(
            @RequestParam(value = "account", required = true) String account,
            @RequestParam(value = "password",required = true) String password,
            @RequestParam("code") String code,
            @RequestParam(value = "username",required = false,defaultValue = "默认用户名") String username
    ){
        UserAccountModel user = new UserAccountModel(account,password,username);

        return userAccountRepository.save(user);
    }

    public void AuthSession(){

    }

    @SneakyThrows
    @ApiOperation("验证码")
    @GetMapping(value = "/code",produces ="image/jpeg")
    public String getCode(HttpServletResponse response){
        VerifyCodeGenerate iVerifyCodeGen = new VerifyCodeTool();
//设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 30);
            String code = verifyCode.getCode();

            session.setAttribute("code",code);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        return "验证码获取成功";
    }



    @ApiOperation("注销登录")
    @SneakyThrows
    @GetMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
