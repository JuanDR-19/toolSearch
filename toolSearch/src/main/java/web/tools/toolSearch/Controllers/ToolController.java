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

    @GetMapping(value="/get_tool/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByid(@PathVariable Integer ID){
        return tools.searchToolById(ID);
    }

    @GetMapping(value="/get_tool/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Tool> getToolByName(@PathVariable String name){
        return tools.searchToolByName(name);
    }





}
