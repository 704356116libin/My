package bin.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 用户信息实体类
 */
@Entity //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "tb_user", schema = "db_shop")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "pro_userpwd_security", procedureName = "pro_userpwd_security", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "username", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "password", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "security", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "answer", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "phone", type = String.class)})}
)
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
    @Column(length = 15, name = "username", nullable = false, unique = true)
    private String username;//用户ID(字母和常用符号组成)
    @Column(length = 15, name = "password", nullable = false)
    private String password;//密码,(字母和常用符号组成)
    @Column(length = 40, name = "security", nullable = false)
    private String security;//用来找回密码的问题
    @Column(length = 20, name = "answer", nullable = false)
    private String answer;//密保问题的答案
    @Column(length = 11, name = "phone", nullable = false)
    private String phone;
    @Column(name = "time")
    private Date time;
    @Column(name="role_id")
    private int role_id;
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
