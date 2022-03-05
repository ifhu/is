package top.ifhu.api.dao.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "pi_user_account")
public class UserAccount{

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "account_id", unique = true, nullable = false, length = 32)
    private String userAccountId;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "账户名必须是邮箱")
    @Column(name = "account" ,unique = true ,nullable = false,length = 50)
    private String userAccount;

    @NotBlank(message = "用户名不能为空")
    @Column(name = "username" ,unique = false ,nullable = false,length = 50)
    private String username;

    @Length(min = 8, max = 20,message = "密码长度必须在8-20位")
    @NotBlank(message = "密码不能为空")
    @Column(name = "password" ,unique = false ,nullable = false,length = 50)
    private String userPassword;

}
