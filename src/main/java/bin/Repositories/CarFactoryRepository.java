package bin.Repositories;

import bin.Models.Car;
import bin.Models.CarFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarFactoryRepository extends JpaRepository<CarFactory, Integer> {
	/**
	 * 查询指定汽车厂商的信息
	 */
	@Query(value = "SELECT * FROM factory where id = ?1 ",nativeQuery = true)
	List<CarFactory> getCarFactoryById(int id);

}
