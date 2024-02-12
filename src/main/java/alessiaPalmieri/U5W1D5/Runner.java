package alessiaPalmieri.U5W1D5;


import alessiaPalmieri.U5W1D5.DAO.BuildingService;
import alessiaPalmieri.U5W1D5.DAO.ReservationService;
import alessiaPalmieri.U5W1D5.DAO.UserService;
import alessiaPalmieri.U5W1D5.DAO.WorkspaceService;
import alessiaPalmieri.U5W1D5.Enum.WorkspaceType;
import alessiaPalmieri.U5W1D5.entities.Building;
import alessiaPalmieri.U5W1D5.entities.Reservation;
import alessiaPalmieri.U5W1D5.entities.User;
import alessiaPalmieri.U5W1D5.entities.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private UserService userService;
    @Autowired
    private WorkspaceService workspaceService;


    @Override
    public void run(String... args){

        //Users
        User user = new User("ale", "Alessia Palmieri", "ale@gmail.com");
        User user1 = new User("enri", "Enrique Iglesias", "enri@gmail.com");

        //Buildings
        Building building = new Building("Apple", "Piazza del Liberty", "Milan");
        Building building1 = new Building("Microsoft", "Via Cristoforo Colombo", "Rome");

        //Find Building By Name
        buildingService.findByName("Microsoft");

        //Workspaces
        Workspace workspace = new Workspace("Private workspace to better focus on your goals!", WorkspaceType.PRIVATE, 10 , building);
        Workspace workspace1 = new Workspace("Open-space workspace to work better with your colleagues!", WorkspaceType.OPENSPACE, 110, building);
        Workspace workspace2 = new Workspace("Meeting Room workspace to share emotions!", WorkspaceType.MEETING_ROOM, 70, building1);

        //Find Available Workspaces By Date
        workspaceService.findByAvailableWorkspaceByDate(LocalDate.now());

        //Find Workspaces By Type && City
        workspaceService.findWorkspaceByTypeAndCity(WorkspaceType.OPENSPACE, "Milan");

        //Reservations
        Reservation reservation = new Reservation(LocalDate.now(), user, workspace);
        Reservation reservation1 = new Reservation(LocalDate.now(), user1, workspace1);

        //Find Reservation By Date
        reservationService.findByDate(LocalDate.now());

        //Verify Reservation is not available in the same day for the same user
        Reservation reservation2 = new Reservation(LocalDate.now(), user1, workspace1);


        //Save
        userService.save(user);
        userService.save(user1);
        buildingService.save(building);
        buildingService.save(building1);
        workspaceService.save(workspace);
        workspaceService.save(workspace1);
        workspaceService.save(workspace2);
        reservationService.save(reservation);
        reservationService.save(reservation1);
        reservationService.save(reservation2);
    }
}
