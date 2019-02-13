package bin.Models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 汽车模型类(测试User关系)
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "car", schema = "db_my")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id//声明此列为主键,作为映射对象的标识符
    /**
     *  @GeneratedValue注解来定义生成策略
     *  GenerationType.TABLES 当前主键的值单独保存到一个数据库的表中
     *  GenerationType.SEQUENCE  利用底层数据库提供的序列生成标识符
     *  GenerationType.IDENTITY 采取数据库的自增策略
     *  GenerationType.AUTO 根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column( name = "name",nullable = false)
    private String name;//汽车名字
    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable=true,unique=true)
    private User user;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public Car() {
        System.out.println("Car 模型装配成功");
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
