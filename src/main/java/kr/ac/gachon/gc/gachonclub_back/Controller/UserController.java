package kr.ac.gachon.gc.gachonclub_back.Controller;

import kr.ac.gachon.gc.gachonclub_back.Domain.User;
import kr.ac.gachon.gc.gachonclub_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/getAll")
    public List getAllUser(){
        return this.userService.findAll();
    }

    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable String id){
        return this.userService.findById(id);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/user/edit")
    public User modifyUser(@RequestBody User user){
        return this.userService.editUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean deleteUser(@PathVariable String id){
        return this.userService.deleteById(id);
    }
}
