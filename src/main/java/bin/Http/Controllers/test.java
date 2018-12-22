package bin.Http.Controllers;

import bin.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class test {

    @Resource
    private UserRepository userRepository;
    public static void main(String args[]){
      test test=new test();
      System.out.println(test.userRepository);
    }

    public test() {
        System.out.println("test测试类读取成功");
    }
}
