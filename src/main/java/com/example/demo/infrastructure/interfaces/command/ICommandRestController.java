package com.example.demo.infrastructure.interfaces.command;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface ICommandRestController {
    @PostMapping(value = "/runService", produces = {"application/json"})
    ResponseEntity<?> runService();

    @PostMapping(value = "/stopService", produces = {"application/json"})
    ResponseEntity<?> stopService();
}
