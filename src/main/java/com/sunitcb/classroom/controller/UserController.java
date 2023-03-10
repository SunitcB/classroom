package com.sunitcb.classroom.controller;

import com.sunitcb.classroom.domain.User;
import com.sunitcb.classroom.domain.dto.ResponseModel;
import com.sunitcb.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final ResponseModel responseModel;
    @Autowired
    UserController(UserService userService, ResponseModel responseModel){
        this.userService = userService;
        this.responseModel = responseModel;
    }

    @GetMapping
    public ResponseEntity<ResponseModel> getAll(@RequestParam(required = false) boolean filter){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseModel> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseModel> saveUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<ResponseModel> updateUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<ResponseModel> getPostsByUser(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getPostsByUser(id));
    }
}
