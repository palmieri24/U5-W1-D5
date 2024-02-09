package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceDAO extends JpaRepository<Workspace, Long> {
}
