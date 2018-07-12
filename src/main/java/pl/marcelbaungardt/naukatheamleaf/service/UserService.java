package pl.marcelbaungardt.naukatheamleaf.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcelbaungardt.naukatheamleaf.error.UserNotFoundExpection;
import pl.marcelbaungardt.naukatheamleaf.model.User;
import pl.marcelbaungardt.naukatheamleaf.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(UserNotFoundExpection::new);
        return user;
    }

    public void createUser(User user) {
        log.debug("Creting user with data: {}",user);
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }
}
