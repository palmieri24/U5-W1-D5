package alessiaPalmieri.U5W1D5.DAO;

import alessiaPalmieri.U5W1D5.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void save(User user) {
        userDAO.save(user);
        System.out.println("User successfully saved!");
    }

    public List<User> findByUsername(String username){
        return userDAO.findByUsername(username);
    }

    public List<User> findByFullname(String fullname){
        return userDAO.findByFullname(fullname);
    }

    public List<User> findByEmail(String email) {
        return userDAO.findByEmail(email);
    }


}
