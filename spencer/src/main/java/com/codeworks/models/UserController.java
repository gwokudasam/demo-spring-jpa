package com.codeworks.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : gwokudasam
 * @Date : 17/8/2017
 */

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userRepository.findOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        userRepository.delete(id);
        return ResponseEntity.ok("user deleted!");
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok("user saved!");
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        if (user.getId() == null) throw new RuntimeException("user id is missing");
        User userFromDatabase = userRepository.findOne(user.getId());
        if (userFromDatabase == null) throw new RuntimeException("user not in database");
        userRepository.save(user);
        return ResponseEntity.ok("user updated");
    }

}
