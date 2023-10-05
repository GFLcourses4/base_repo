package com.example.base_repo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/scenario")
public class BaseController {

//    private final UserService userService;

//    public BaseController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping
    public ResponseEntity getUser() {
//        User user = userService.getUser(id);
//        if (user != null) {
        User user = new User();
        user.setId(1);
        user.setFirstName("FirstName");
        user.setLastName("LastName");
            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.badRequest().body("User not found");
//        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid List<User> user) throws Exception {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/all")
    public ResponseEntity createListUser(@RequestBody List<@Valid User> user) throws Exception {
//        userService.createAll(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestParam(name = "id") int id) {
//        userService.remove(id);
        return ResponseEntity.ok().build();
    }
}
