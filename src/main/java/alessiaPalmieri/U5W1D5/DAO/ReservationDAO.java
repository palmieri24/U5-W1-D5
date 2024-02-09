package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO extends JpaRepository<Reservation, Long> {
}
