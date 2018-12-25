package bin.Http.Controllers;

import bin.Repositories.UserRepository;
import bin.Tools.UserTool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class test {

    public static void main(String args[]){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserTool userTool=context.getBean("userTool",UserTool.class);
        System.out.println(userTool.getUserCount());
    }

    public test() {

    }
}
