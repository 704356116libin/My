package bin.Impls;

import bin.Interfaces.UserInterface;
import bin.Models.User;
import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userImpl")
public class UserImpl implements UserInterface {

    @Resource
    private UserRepository userRepository;
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
     * @return
     */
    @Override
    public int getUserCount() {
        return userRepository.getUserCount();
    }

    /**
     * 分页获取所有用户的信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<User> getAllUser(int page, int limit) {
        return userRepository.showUser(page,limit);
    }
}
