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

    public ToolRepository getRepo() {
        return Repo;
    }

    public void setRepo(ToolRepository repo) {
        Repo = repo;
    }

    public ArrayList<Tool> SearchAll(){
        return (ArrayList<Tool>) Repo.findAll();
    }

    public Optional<Tool> searchToolById(Integer id){
        return Repo.findById(id);
    }

    public Optional<Tool> searchToolByName(String Name){
        return Repo.findByName(Name);
    }

    public Optional<Tool> searchToolByBrand(Integer brand_id){
        return Repo.findByBrandId(brand_id);
    }

    public Optional<Tool> searchToolByCity(Integer City_id){
        return Repo.findByCityId(City_id);
    }
}