package web.tools.toolSearch.Services;

import web.tools.toolSearch.Entities.Tool;
import web.tools.toolSearch.Repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    ToolRepository Repo;

    public ArrayList<Tool> SearchAll(){
        return (ArrayList<Tool>) Repo.findAll();
    }

    public Optional<Tool> searchToolById(Integer id){
        return Repo.findById(id);
    }

    public ArrayList<Tool> searchToolByName(String Name){
        return Repo.findByName(Name);
    }


    public ArrayList<Tool> searchToolsByBrandName(String brandName) {
        return Repo.findByBrandName(brandName);
    }

}