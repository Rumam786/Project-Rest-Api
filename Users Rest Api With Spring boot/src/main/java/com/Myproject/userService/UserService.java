package com.Myproject.userService;

import com.Myproject.Entities.Users;
import com.Myproject.Exceptions.UserNotFoundException;
import com.Myproject.dao.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class UserService {
    @Autowired
    private userRepository userRepository;

    public List<Users> mylist = new CopyOnWriteArrayList<>();

//    Add users
    public Users addusers(Users users) {
        return userRepository.save(users);
    }

//    Get Users
    public List<Users> getusers() {
        return userRepository.findAll();
    }

//    Get a User
    public Users getauser(int userid) {
       Optional<Users> optionalUsers = userRepository.findById(userid);
       if (!optionalUsers.isPresent())
           throw new UserNotFoundException("User Record is Not Available.......");
       return optionalUsers.get();
    }

//    Update Users
public Users updateuser(int userid, Users users) {
        Optional<Users> usersOptional = userRepository.findById(userid);
        if (usersOptional.isPresent())
            users.setUserid(userid);
        else {
            throw new UserNotFoundException("User Record is Not Available.......");
        }
    return userRepository.save(users);
}

//    Delete User
    public void deleteuser(int userid) {
        userRepository.deleteById(userid);
    }
}
