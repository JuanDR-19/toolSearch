package web.tools.toolSearch.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.tools.toolSearch.Entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
    @Query("SELECT t FROM Tool t WHERE t.name LIKE %:name%")
    ArrayList<Tool> findByName(@Param("name") String name);

    @Query("SELECT t FROM Tool t WHERE t.brand_id.name = :brandName")
    ArrayList<Tool> findByBrandName(@Param("brandName") String brandName);

}
