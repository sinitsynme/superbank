package ru.sintsynme.transferservice.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferRestController {

    @GetMapping("hello")
    public ResponseEntity<String> helloFromTransfer(){
        return ResponseEntity.ok("Hello from TransferService API");
    }


}
