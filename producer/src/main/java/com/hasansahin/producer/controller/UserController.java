package com.hasansahin.producer.controller;

import com.hasansahin.producer.dto.User;
import com.hasansahin.producer.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String healthCheck(@RequestBody String message) {
        userService.healthCheck(message);
        return "Message is sent successfully!";
    }

    @PostMapping
    public User sendUserMessage(@RequestBody User user) {
        return userService.sendUserMessage(user);
    }
}
