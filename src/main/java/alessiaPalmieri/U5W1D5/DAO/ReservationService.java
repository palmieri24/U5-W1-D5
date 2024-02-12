package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.Exception.ItemNotFoundException;
import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.User;
import alessiaPalmieri.U5W1D5.entities.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;
    @Autowired
    private WorkspaceDAO workspaceDAO;
    @Autowired
    private UserDAO userDAO;

    public void save(Reservation reservation){
       List<Workspace> workspacesAvailable = workspaceDAO.findAvailableWorkspaceByDate(reservation.getDate());
       boolean isAvailable = workspacesAvailable.stream().anyMatch(workspace -> workspace.getId().equals(reservation.getWorkspace().getId()));

       List<Reservation> reservations = reservationDAO.findByUser(reservation.getUser());
       boolean isReserved = reservations.stream().anyMatch(reservation1 -> reservation1.getDate().equals(reservation.getDate()));

       if(isAvailable){
           if(!isReserved){
           reservationDAO.save(reservation);
           System.out.println("Reservation successfully saved!");
       } else {
           System.out.println("Sorry, the user has a reservation for the following date!");
       }
    } else {System.out.println("Sorry, the workspace is not available!"); } }

    public void findByDate(LocalDate date){
        List<Reservation> reservations = reservationDAO.findByDate(date);
    }}

