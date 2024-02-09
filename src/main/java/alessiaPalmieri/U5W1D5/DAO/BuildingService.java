package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingDAO buildingDAO;

    public void save(Building building){
        buildingDAO.save(building);
        System.out.println("Building successfully saved!");
    }

    public Building findById(long id){
        return buildingDAO.findById(id);
    }

    public List<Building> findByName(String name){
        return buildingDAO.findByName(name);
    }
    public List<Building> findByAddress(String address) {
        return buildingDAO.findByAddress(address);
    }
    public List<Building> findByCity(String city) {
        return buildingDAO.findByCity(city);
    }
}
