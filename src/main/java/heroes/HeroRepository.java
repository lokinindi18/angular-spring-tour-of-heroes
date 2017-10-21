package heroes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HeroRepository extends CrudRepository<Hero, Long> {

	@Query("from Hero h where lower(h.name) like CONCAT('%', lower(:name), '%')")
	public Hero[] findByName(@Param("name") String name);

}