package web.tools.toolSearch.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer city_id;
    private String name;

    @ManyToMany(mappedBy = "cities")
    private List<Tool> availability;
}