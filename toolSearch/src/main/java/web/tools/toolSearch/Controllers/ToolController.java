package web.tools.toolSearch.Controllers;

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

    @GetMapping(value="/get_tool_name/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Tool> getToolByName(@PathVariable String name){
        return tools.searchToolByName(name);
    }

    @GetMapping(value="/get_tool_brand/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Tool> getToolByBrand(@PathVariable String name){
        return tools.searchToolsByBrandName(name);
    }

}
