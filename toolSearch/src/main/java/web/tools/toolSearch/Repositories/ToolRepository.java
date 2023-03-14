package web.tools.toolSearch.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.tools.toolSearch.Entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


public interface ToolRepository extends JpaRepository<Tool, Integer> {
    @Query("SELECT t FROM Tool t WHERE t.name LIKE %:name%")
    Optional<Tool> findByName(@Param("name") String name);

    @Query("SELECT t FROM Tool t WHERE t.brand_id LIKE %:brand_id%")
    Optional<Tool> findByBrandId(@Param("brand_id") Integer brand_id);

    @Query("SELECT t FROM Tool t WHERE t.city_id LIKE %:city_id%")
    Optional<Tool> findByCityId(@Param("city_id") Integer city_id);
}
