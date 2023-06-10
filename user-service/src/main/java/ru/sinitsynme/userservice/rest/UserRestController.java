package ru.sinitsynme.userservice.rest;

import org.apache.tomcat.util.http.parser.Authorization;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ROLE_bank_user')")
    public ResponseEntity<String> helloFromUser(@AuthenticationPrincipal Jwt jwt){
        String auths = jwt.getClaims().toString();
        return ResponseEntity.ok(String.format("Hello from UserService API! \n\n%s", auths));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_bank_admin')")
    public ResponseEntity<String> restrictedMethod(@AuthenticationPrincipal Jwt jwt) {
        String auths = jwt.getClaims().toString();
        return ResponseEntity.ok(String.format("Restricted method of UserService API \n\n    JWT \n\n%s", auths));
    }
}
