package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.Enum.WorkspaceType;
import alessiaPalmieri.U5W1D5.entities.Building;
import alessiaPalmieri.U5W1D5.entities.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceDAO workspaceDAO;

    @Autowired
    private BuildingService buildingService;

    public void save(Workspace workspace){
        workspaceDAO.save(workspace);
        System.out.println("Workspace saved with success!");
    }

    public void findWorkspaceByTypeAndCity(WorkspaceType type, String city){
        Building building = (Building) buildingService.findByCity(city);
        List<Workspace> workspaces = workspaceDAO.findWorkspaceByTypeAndCity(type, building);
    }
    public List<Workspace> findByAvailableWorkspaceByDate(LocalDate date){
        return workspaceDAO.findAvailableWorkspaceByDate(date);
    }

}
