package prog.service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import prog.domain.User;


import java.util.List;
import java.util.Optional;
public  interface UserService {
    void addUser(User user);
    List<User> findUsers();
    public Boolean checkPassword(String login, String password);
}
