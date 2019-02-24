package bin.Mapper;

import bin.Interfaces.UserInterface;
import bin.Models.Car;
import bin.Models.User;
import bin.SqlProvider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserMApper  {
    @Select("select * from user  limit #{offset},#{limit}")
    List<User> getAllUser(@Param("offset")int offset,@Param("limit")int limit);
    @Select("select count(*)from user")
     int getUserCount();//查询用户总数
    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "email_verified",property = "email_verified"),
            @Result(column = "name",property = "name"),
            @Result(column = "tel",property = "tel"),
            @Result(column = "tel_verified",property = "tel_verified"),
            //一对多
            @Result(column = "id",property = "cars",many = @Many(select = "bin.Mapper.CarMapper.selectCarByUserId",
                    fetchType = FetchType.LAZY))
    })
    User selectUserById(@Param("id")int id);

    /**
     * 动态查询user
     */
    @SelectProvider(type = UserSqlProvider.class,method = "selectUserWithParms")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    User selectUserWithParms(Map<String,Object> parms);
    @Delete("delete from user where id=#{id}")
    int  deleteUser(int id);//根据id删除用户
    @Update("update user set email=#{email},email_token=#{email_token},email_verified=#{email_verified}," +
            "name=#{name},password=#{password},tel=#{tel},tel_verified=#{tel_verified}")
    void  updateUser(User user);//更新用户信息
    @Insert("insert into user(email,email_token,email_verified,name,password,tel,tel_verified)" +
            "values(#{email},#{email_token},email_verified),name,password,tel,tel_verified")
    int  addUser(User user);//添加用户信息

}
