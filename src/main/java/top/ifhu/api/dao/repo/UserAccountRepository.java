package top.ifhu.api.dao.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import top.ifhu.api.dao.entity.UserAccountModel;


public interface UserAccountRepository extends JpaRepository<UserAccountModel,String> {
}