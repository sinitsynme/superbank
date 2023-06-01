package ru.sinitsynme.userservice.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloFromUser(){
        return ResponseEntity.ok("Hello from UserService API!");
    }
}
