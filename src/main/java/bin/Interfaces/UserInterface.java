package bin.Interfaces;

import bin.Models.User;

import java.util.List;

public interface UserInterface {
     int getUserCount();//查询用户总数
     List<User> getAllUser(int page, int limit);//获取所有的用户
     int  deleteUser(int id);//根据id删除用户
     void  updateUser(User user);//更新用户信息
     int  addUser(User user);//添加用户信息
     /**
      * 测试方法
      */
     public void demo();
}
