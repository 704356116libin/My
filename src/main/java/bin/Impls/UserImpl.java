package bin.Impls;

import bin.Interfaces.UserInterface;
import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Override
    public int getUserCount() {
        return userRepository.getUserCount();
    }
}
