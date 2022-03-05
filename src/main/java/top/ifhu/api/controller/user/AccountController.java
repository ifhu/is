package top.ifhu.api.controller.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.ifhu.api.dao.entity.UserAccount;
import top.ifhu.api.dao.repo.UserAccountRepository;

import java.util.List;

@RestController
@Api("账户管理")
@RequestMapping("/user/account")
public class AccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;
    @ApiOperation("添加账户")
    @PostMapping("/register")
    public UserAccount addAccount(@RequestBody UserAccount account){
            return userAccountRepository.save(account);
    }

    @GetMapping("/all")
    public List<UserAccount> queryAll(){
        return userAccountRepository.findAll();
    }
}
