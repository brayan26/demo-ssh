package com.example.demo.infrastructure.interfaces.helm;

import com.example.demo.application.helm.version.FindVersions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/helm")
public class HelmRestController implements IHelmRestController {

    @Autowired
    FindVersions findVersions;

    @Override
    public ResponseEntity<?> listCharts() throws IOException {
        return ResponseEntity.ok(findVersions.find());
    }
}
