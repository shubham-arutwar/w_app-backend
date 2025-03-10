package com.w_app.controller;

import com.w_app.entity.User;
import com.w_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.w_app.utils.Constants.USERS_ENDPOINT;

@RestController
@RequestMapping(USERS_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return ResponseEntity.ok(userService.createUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<UUID> deleteUser(@PathVariable UUID id) {
//        return ResponseEntity.ok(userService.deleteUser(id));
//    }
}
