package top.ifhu.api.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Table(name = "user_account")
@GenericGenerator(name = "auto-uuid", strategy = "uuid")
public class UserAccountModel {
    @Id
    @GeneratedValue(generator = "auto-uuid")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String Id;

    @Column(name = "user_id", unique = true, nullable = false, length = 50)
    private String userId;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "账户名必须是邮箱")
    @Column(name = "account" ,unique = true ,nullable = false,length = 50)
    private String userAccount;

    @Column(name = "user_name"  ,nullable = false,length = 50)
    private String username = "默认用户名";

    @Length(min = 8, max = 20,message = "密码长度必须在8-20位")
    @NotBlank(message = "密码不能为空")
    @Column(name = "password"  ,nullable = false,length = 50)
    private String userPassword;

    @Column(name="freezed" ,nullable = false)
    private boolean isFreezed = false;

    public UserAccountModel(String account,String password,String username){
        this.userId = UUID.randomUUID().toString().replaceAll("-","");
        this.userAccount = account;
        this.userPassword = password;
        this.username = username;
    }
}
