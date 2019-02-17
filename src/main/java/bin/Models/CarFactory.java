package bin.Models;

import javax.persistence.*;
import java.util.List;

/**
 * 汽车制造厂商
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "factory", schema = "db_my")
public class CarFactory {
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
    private String name;//厂商名字
    @Column( name = "address",nullable = true)
    private String address;
    @ManyToMany(targetEntity = Car.class,fetch = FetchType.EAGER)
    @JoinTable(name = "car_factory",
            joinColumns = @JoinColumn(name = "factory_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "car_id",referencedColumnName = "id")
    )
    private List<Car> cars;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarFactory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
