package top.ifhu.api.dao.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Validated
@Table(name = "user_account")
public class UserAccount{
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", unique = true, nullable = false, length = 32)
    private String Id;

    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "user_id", unique = true, nullable = false, length = 32)
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
}
