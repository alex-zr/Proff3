package prog.service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import prog.dao.UserRepository;
import prog.domain.User;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(User user){
        userRepository.save(user);
    }
    @Override
    @Transactional
    public List<User> findUsers() {
        return userRepository.findAll();
    }
    @Override
    public Boolean checkPassword(String login, String password){
        List<User> map = findUsers();
        for(User user :map){
         if(user.getLogin().equals(login)& user.getPassword().equals(password))
              return true;
        }

        return false;
    }

}
