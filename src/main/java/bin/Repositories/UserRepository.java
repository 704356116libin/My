package bin.Repositories;

import bin.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * 验证用户登录
	 */
	@Query(value = "select md5(?1) =(select password from tb_user WHERE  username=?2)", nativeQuery = true)
	int loginUser(String password, String username);

	/**
	 * 验证用户是否已经存在
	 */
	@Query(value = "select count(*)from tb_user where username=?1",nativeQuery=true)
	int testUser(String username);

	/**
	 * 调用存储用户的存储过程
	 */
	@Procedure( procedureName = "pro_userpwd_security")
	void addUser(String username, String password, String security, String answer, String phone);
	/**
	 * 查询所有用户信息
	 */
	@Query(value = "SELECT * FROM user order by id limit ?1,?2 ",nativeQuery = true)
	List<User> showUser(int offset, int limit);
	/**
	 * 查询用户数据总数
	 */
	@Query(value = "select count(*)from user ",nativeQuery = true)
	int getUserCount();
	@Query(value = "delete from user where id=?1",nativeQuery = true)
	int  deleteUser(int id);//根据id删除用户
//	@Modifying
//	void  updateUser(User user);//更新用户信息

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
//	@Query(value = "insert into user()",nativeQuery = true)
//	int  addUser(User user);
}
