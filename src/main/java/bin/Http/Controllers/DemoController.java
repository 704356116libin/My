package bin.Http.Controllers;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

@ParentPackage("base")
@Namespace(value = "/demo")
@Results({
        @Result(name="6666",location = "/index.jsp"),
})
public class DemoController extends ActionSupport{
    public DemoController() {
        System.out.println("demo 初始化!!!!!!!!!!!!!!!!!111");
    }

    @Action("/hello")
    public String demo(){
       return "6asd666";
     }
}
