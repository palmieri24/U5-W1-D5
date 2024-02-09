package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void save(User user) {
        userDAO.save(user);
        System.out.println("User successfully saved!");
    }

}
