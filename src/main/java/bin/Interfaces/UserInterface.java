package bin.Interfaces;

import bin.Models.User;

import java.util.List;

public interface UserInterface {
    public int getUserCount();//查询用户总数
    public List<User> getAllUser(int page, int limit);//获取所有的用户
}
