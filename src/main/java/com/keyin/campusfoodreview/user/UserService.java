package com.keyin.campusfoodreview.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRestRepository userRestRepository;

    public User saveNewUser(User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        return userRestRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRestRepository.findAll();
    }
    public User getUserById(Long userId){
        return userRestRepository.findById(userId).get();
    }
    public void deleteUserById(Long userId){
        userRestRepository.deleteById(userId);
    }
    public boolean userExists(Long userId){
        return userRestRepository.existsById(userId);
    }

}
