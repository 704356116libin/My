package bin.Http.Controllers;

import bin.Impls.UserImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ParentPackage("base")
@Namespace(value = "/demo")
@Results({
        @Result(name="6666",location = "/index1.jsp"),
})
public class DemoController extends ActionSupport{
    public DemoController() {
        System.out.println("demo 初始化!!!!!!!!!!!!!!!!!111");
    }

    @Action("/hello")
    public String demo(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserImpl userTool=context.getBean("userImpl",UserImpl.class);
        System.out.println(userTool.getUserCount());
       return "6666";
     }
}
