package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingDAO extends JpaRepository<Building, Long> {
    Building findById(long id);
    List<Building> findByName(String name);
    List<Building> findByAddress(String address);
    List<Building> findByCity(String city);
}
