package com.Myproject.Controllers;

import com.Myproject.Entities.Users;
import com.Myproject.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public Users adduser(@RequestBody Users users) {
        return userService.addusers(users);
    }

    @GetMapping("/users")
    public List<Users> getallusers() {
        return userService.getusers();
    }

    @GetMapping("/users/{uid}")
    public Users getauser(@PathVariable("uid") int userid) {
        return userService.getauser(userid);
    }

    @PutMapping("/users/{uid}")
    public Users updateusers(@PathVariable("uid") int userid ,@RequestBody Users users) {
        return userService.updateuser(userid, users);
    }

    @DeleteMapping("/users/{uid}")
    public void deleteuser(@PathVariable("uid") int userid) {
        this.userService.deleteuser(userid);
    }

}
