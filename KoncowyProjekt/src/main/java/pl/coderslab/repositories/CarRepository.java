package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pl.coderslab.entities.Car;


public interface CarRepository extends JpaRepository<Car, Long> {
	
	
	@Query("select car from Car car where model like %:name%")
	List<Car> findByModel(@Param("name") String name);
	
	@Query("select car from Car car where brand like %:name%")
	List<Car> findByBrand(@Param("name") String name);

	@Query("select car from Car car where city like %:name%")
	List<Car> findByCity(@Param("name") String name);
	


}
