package bin.Tools;

import bin.Interfaces.UserInterface;
import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("userTool")
public class UserTool implements UserInterface {

    @Resource
    private UserRepository userRepository;
//    private static volatile UserTool userTool;

    private UserTool() {
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
