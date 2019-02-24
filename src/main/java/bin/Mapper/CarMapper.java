package bin.Mapper;

import bin.Models.Car;
import bin.Models.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {
    /**
     * 查找某个用户所有的汽车
     * @param id
     * @return
     */
    @Select("select * from car where user_id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
    })
    Car selectCarByUserId(@Param("id") int id);
}
