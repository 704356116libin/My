package bin.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 用户信息实体类
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "user", schema = "db_my")
//@NamedStoredProcedureQueries({
//        @NamedStoredProcedureQuery(name = "pro_userpwd_security", procedureName = "pro_userpwd_security", parameters = {
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "username", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "security", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "answer", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "phone", type = String.class)})}
//)
//通过 @Table 为实体Bean指定对应数据库表，目录和schema的名字
//@UniqueConstraints 可以定义表的唯一约束。在title,和content加上唯一约束
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int PAGE_SIZE = 9;//每页的最大数据条数
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
    @Column(length = 15, name = "name", nullable = false, unique = true)
    private String name;//用户ID(字母和常用符号组成)
    @Column(length = 15, name = "password", nullable = false)
    private String password;//密码,(字母和常用符号组成)
    public User() {
        System.out.println("user读取成功");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
