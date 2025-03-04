package org.example.postusercomment.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public String deleteUser(Long id) {

        boolean userExists = userRepository.checkIfExistsById(id);
        if (userExists) {
            userRepository.delete(id);
            boolean userDeleted = userRepository.checkIfExistsById(id);
            if (userDeleted) {
                return "User with id " + id + " is not deleted.";
            } else {
                return "User with id " + id + " successfully deleted";
            }
        } else {
            return "User with id " + id + " does not exist.";
        }

    }
}
