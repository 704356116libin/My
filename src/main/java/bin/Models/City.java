package bin.Models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 城市模型类
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "city", schema = "db_my")
public class City implements Serializable {
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
    @Column(length = 15, name = "province_id", nullable = false)
    private int province_id; //城市所属的省份id
    @Column( name = "name",nullable = false)
    private String name;//城市名称
    @Column( name = "description",columnDefinition = "")
    private String description;//城市描述
    @Column( name = "data",columnDefinition = "")
    private String data;//城市的json信息
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public City() {
        System.out.println("City模型装配成功");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", province_id=" + province_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
