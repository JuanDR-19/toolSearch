package web.tools.toolSearch.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tool implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String img;
    private String description;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand_id;
    private double price;

    @ManyToMany
    private List<City> cities;
    private Integer quantity;

}
