package bin.SqlProvider;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserSqlProvider {
    private static String table="user";
    public String selectUserWithParms(Map<String,Object> param){
        return new SQL(){
            {
                SELECT("*");
                FROM(table);
                if(param.get("id")!=null){
                    WHERE("id=#{id}");
                }
                if(param.get("tel")!=null){
                    WHERE("tel=#{tel}");
                }
            }
        }.toString();
    }
}
