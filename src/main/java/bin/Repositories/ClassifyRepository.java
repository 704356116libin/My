package bin.Repositories;

import bin.Models.Car;
import bin.Models.Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyRepository extends JpaRepository<Classify, Integer> {
	/**
	 * 查询所有用户信息
	 */
	@Query(value = "SELECT * FROM classify where id = ?1 ",nativeQuery = true)
	List<Classify> getClassifyById(int id);

}
