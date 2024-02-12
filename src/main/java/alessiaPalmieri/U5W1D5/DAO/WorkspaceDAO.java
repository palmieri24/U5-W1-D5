package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.Enum.WorkspaceType;
import alessiaPalmieri.U5W1D5.entities.Building;
import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.User;
import alessiaPalmieri.U5W1D5.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkspaceDAO extends JpaRepository<Workspace, Long> {
    List<Workspace> findWorkspaceByTypeAndCity(WorkspaceType type, Building building);
    //Cerco una postazione disponibile per una determinata data
    @Query("SELECT w FROM Workspace w WHERE w NOT IN (SELECT r.workspace FROM Reservation r WHERE r.date = :date)")
    List<Workspace> findAvailableWorkspaceByDate(@Param("date") LocalDate date);
}
