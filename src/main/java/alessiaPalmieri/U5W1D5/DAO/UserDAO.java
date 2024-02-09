package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findByFullname(String fullname);
    List<User> findByEmail(String email);
}
