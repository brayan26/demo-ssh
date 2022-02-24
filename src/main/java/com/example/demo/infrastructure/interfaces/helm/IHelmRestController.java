package com.example.demo.infrastructure.interfaces.helm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

public interface IHelmRestController {
    @GetMapping(value = "/listCharts", produces = {"application/json"})
    ResponseEntity<?> listCharts() throws IOException;
}
