package top.ifhu.api.dao.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Data
@Table(name = "pi_user_account")
public class UserAccount{

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "account_id", unique = true, nullable = false, length = 32)
    private String userAccountId;

    @Column(name = "account" ,unique = true ,nullable = false,length = 50)
    private String userAccount;

    @Column(name = "username" ,unique = false ,nullable = false,length = 50)
    private String username;
    @Column(name = "password" ,unique = false ,nullable = false,length = 50)
    private String userPassword;


}
