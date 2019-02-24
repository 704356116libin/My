package bin.Impls;

import bin.Interfaces.UserInterface;
import bin.Mapper.UserMApper;
import bin.Models.User;
import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userImpl")
public class UserImpl implements UserInterface {

    @Resource
    private UserRepository userRepository;//hibernate仓库
    @Resource
    private UserMApper userMApper;//mybatis仓库类实现
//    private static volatile UserTool userTool;

    private UserImpl() {
        System.out.println("create " + getClass().getSimpleName());
    }

//    public static UserTool getInstance(){
//        synchronized (UserTool.class) {
//            if (userTool == null) {
//                userTool = new UserTool();
//            }
//        }
//        return userTool;
//    }

    /**
     *
     *
     */
    @Override
    public int getUserCount() {
        return userMApper.getUserCount();
//        return userRepository.getUserCount();
    }

    /**
     * 分页获取所有用户的信息
     */
    @Override
    public List<User> getAllUser(int offset, int limit) {
        return userMApper.getAllUser(offset,limit);
//        return userRepository.showUser(offset,limit);
    }

    /**
     * 通过id移除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(int id) {

        return 0;
    }
    /**
     * 更新用户信息
     */
    @Override
    public void updateUser(User user) {

    }
    /**
     * 添加用户
     */
    @Override
    public int addUser(User user) {
        return 0;
    }

    /**
     * 测试方法
     */
    public void demo(){
       User user= userMApper.selectUserById(1);
       //测试mybatis的一对多实现,举一反三
       user.getCars().forEach(car -> System.out.println(car.getName()));
       //测试mybatis动态sql
        Map<String,Object> parms=new HashMap<>();
        parms.put("id",1);
        System.out.println(userMApper.selectUserWithParms(parms).getId());
       //测试hibernate插入user数据实现
//        User user1=new User();
//        user1.setName("dmeo");
//        user1.setEmail("asdasda");
//        user1.setEmail_token("asdasda");
//        user1.setEmail_verified(1);
//        user1.setTel("12312312");
//        user1.setTel_verified(1);
//        user1.setPassword("123456");

    }
}
