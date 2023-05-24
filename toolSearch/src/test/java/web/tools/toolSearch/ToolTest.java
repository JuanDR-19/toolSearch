package web.tools.toolSearch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import web.tools.toolSearch.Entities.Brand;
import web.tools.toolSearch.Entities.City;
import web.tools.toolSearch.Entities.Tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ToolTest {
    @Test
    public void testToString() {
        // Arrange
        Tool tool = new Tool();
        tool.setId(1);
        tool.setName("Tool1");
        tool.setImg("tool1.jpg");
        tool.setDescription("This is Tool 1");

        Tool tool2 = new Tool(); // Cambiado a tool2
        tool2.setId(2); // Cambiado a tool2
        tool2.setName("Tool2"); // Cambiado a tool2
        tool2.setImg("tool2.jpg"); // Cambiado a tool2
        tool2.setDescription("This is Tool 2"); // Cambiado a tool2

        City city1 = new City();
        city1.setCity_id(1);
        city1.setName("City1");

        City city2 = new City();
        city2.setCity_id(2);
        city2.setName("City2");

        Brand brand1 = new Brand();
        brand1.setBrand_id(1);
        brand1.setName("brand1");
        brand1.setWebsite("brand1.com");

        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        tool.setCities(cities);

        tool.setPrice(200);
        tool.setBrand_id(brand1);
        tool.setQuantity(1);

        String expectedString = "Tool{id=1, name='Tool1', img='tool1.jpg', description='This is Tool 1', brand_id=Brand(brand_id=1, name=brand1, website=brand1.com), price=200.0, cities=[City(city_id=1, name=City1, availability=null), City(city_id=2, name=City2, availability=null)], quantity=1}";
        String actualString = tool.toString();

        assertEquals(expectedString, actualString);
    }
}
