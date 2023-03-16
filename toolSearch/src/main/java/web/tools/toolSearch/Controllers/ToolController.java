package web.tools.toolSearch.Controllers;

import web.tools.toolSearch.Entities.City;
import web.tools.toolSearch.Entities.Tool;
import web.tools.toolSearch.Services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ToolController {
    @Autowired
    ToolService tools;

    @GetMapping(value="/get_tools", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<Tool> getAll(){
        return tools.SearchAll();
    }

    @GetMapping(value="/get_tool/{ID}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByid(@PathVariable Integer ID){
        return tools.searchToolById(ID);
    }

    @GetMapping(value="/get_tool_name",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByName(@RequestBody String name){
        return tools.searchToolByName(name);
    }

    @GetMapping(value="/get_tool_brand/{brand_id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByBrandId(@PathVariable Integer brand_id){
        return tools.searchToolByBrand(brand_id);
    }

    @GetMapping(value="/get_tool_city",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByCity(@RequestBody City city_id){
        return tools.searchToolByCity(city_id);
    }





}
