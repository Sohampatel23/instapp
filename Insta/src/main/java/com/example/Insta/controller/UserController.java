package com.example.Insta.controller;

import com.example.Insta.model.user;
import com.example.Insta.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody user newUser)
    {

        return userService.userSignUp(newUser);
    }

    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return userService.userSignIn(email,password);
    }
}
