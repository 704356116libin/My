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
    @Column(length = 13, name = "tel", nullable = false, unique = true)
    private String tel;//手机号,与用户绑定唯一
    @Column( name = "email")
    private String email;//邮箱
    @Column( name = "email_verified")
    private int email_verified;
    @Column( name = "tel_verified")
    private int tel_verified;
    @Column( name = "password", nullable = false)
    private String password;//密码,(字母和常用符号组成)
    @Column( name = "email_token", nullable = false)
    private String email_token;//y用户邮箱验证token字段
    public User() {
        System.out.println("user读取成功");
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(int email_verified) {
        this.email_verified = email_verified;
    }

    public int getTel_verified() {
        return tel_verified;
    }

    public void setTel_verified(int tel_verified) {
        this.tel_verified = tel_verified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_token() {
        return email_token;
    }

    public void setEmail_token(String email_token) {
        this.email_token = email_token;
    }
}
