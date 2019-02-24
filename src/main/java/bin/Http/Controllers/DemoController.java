package bin.Http.Controllers;

import bin.Impls.CarFactoryImpl;
import bin.Impls.CarImpl;
import bin.Impls.ClassifyImpl;
import bin.Impls.UserImpl;
import bin.Interfaces.UserInterface;
import bin.Models.Car;
import bin.Models.Classify;
import bin.Models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 项目测试类
 */
@ParentPackage("base")
@Namespace(value = "/demo")
@Results({
        @Result(name="6666",location = "/index1.jsp"),
})
public class DemoController extends ActionSupport{
    public DemoController() {
        System.out.println("demo 初始化!!!!!!!!!!!!!!!!!111");
    }
    @Autowired
    @Qualifier("userImpl")
    private UserInterface userInterface;
    @Action("/hibernate")
    public String hibernate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserImpl userTool=context.getBean("userImpl",UserImpl.class);
        CarImpl carImpl=context.getBean("carImpl",CarImpl.class);
        ClassifyImpl classifyImpl=context.getBean("classifyImpl",ClassifyImpl.class);
        CarFactoryImpl carFactoryImpl=context.getBean("carFactoryImpl",CarFactoryImpl.class);
        //一对一测试
        //多对一测试
        System.out.println(carImpl.getCarById(3).get(0).getUser().getName());
        //一对多测试
        List<User> users=userTool.getAllUser(0,10);
//        Iterator<User> it= users.iterator();
//        while (it.hasNext()){
//            Iterator<Car> it_car=it.next().getCars().iterator();
//            while (it_car.hasNext()) {
//                Car car=it_car.next();
//                System.out.println(car.getId());
//                System.out.println("汽车-"+car.getName()+"所对应的用户名为:");
//            }
//        }
        //自关联测试
//        List<Classify> classifies=classifyImpl.getClassifyById(1);
//        if(classifies.size()!=0){
//            digui_classify(classifies.get(0));
//        }else{
//            System.out.println("暂无数据");
//        }
        //多对多测试
        List<Car> cars=carFactoryImpl.getCarFactoryById(1).get(0).getCars();
//        System.out.println(cars.size());
        Iterator<Car> it= cars.iterator();
        while (it.hasNext()){
                Car car=it.next();
                System.out.println(car.getId());
                System.out.println("汽车-"+car.getName()+"所对应的用户名为:");
        }

        Map<String,Object> maps=new HashMap<>();
        maps.put("a",1);
        maps.put("b",2);
        maps.put("c",3);
        System.out.println(maps);
       return "6666";
     }
    @Action("/mybatis")
    public String mybatis(){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserInterface u=context.getBean("userImpl",UserImpl.class);
        u.demo();
        return "6666";
    }
    /**
     * 无限极遍历递归方法
     * @param classify
     */
     protected void digui_classify( Classify classify){
        if(classify.getChild_nodes().size()!=0){
            List<Classify> classifies=classify.getChild_nodes();
                Iterator<Classify> class_it=classifies.iterator();//迭代无限极遍历模型
                while (class_it.hasNext()){
                    Classify classify1=class_it.next();
                    System.out.println(classify1.toString());
                    System.out.println(classify1.getId());
                    digui_classify(classify1);
                }
        }
     }
}
