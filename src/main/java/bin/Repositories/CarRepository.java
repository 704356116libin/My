package bin.Repositories;

import bin.Models.Car;
import bin.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	/**
	 * 查询所有用户信息
	 */
	@Query(value = "SELECT * FROM car where id = ?1 ",nativeQuery = true)
	List<Car> getCarById(int id);

}
