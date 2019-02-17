package bin.Http.Controllers;

import bin.Impls.CarFactoryImpl;
import bin.Impls.CarImpl;
import bin.Impls.ClassifyImpl;
import bin.Impls.UserImpl;
import bin.Models.Car;
import bin.Models.Classify;
import bin.Models.User;
import bin.Repositories.CarRepository;
import bin.Repositories.UserRepository;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

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
//        List<User> users=userTool.getAllUser(0,10);
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
