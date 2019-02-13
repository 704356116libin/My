package bin.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 分类信息模型(无限极遍历)
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "classify", schema = "db_my")
public class Classify implements Serializable {
    /**
     *
     */
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
    @Column( name = "name", nullable = false, unique = true)
    private String name;//分类名
    @Column( name = "info", nullable = false, unique = true)
    private String info;//分类信息json字段
    @ManyToOne(targetEntity = Classify.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Classify parent_node;//父级节点

    @OneToMany(targetEntity = Classify.class,mappedBy = "parent_node",fetch = FetchType.EAGER)
    private List<Classify> child_nodes;//子节点

    public Classify() {
        System.out.println("Classify模型装配成功");
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Classify getParent_node() {
        return parent_node;
    }

    public void setParent_node(Classify parent_node) {
        this.parent_node = parent_node;
    }

    public List<Classify> getChild_nodes() {
        return child_nodes;
    }

    public void setChild_nodes(List<Classify> child_nodes) {
        this.child_nodes = child_nodes;
    }
    @Override
    public String toString() {
        return "Classify{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
