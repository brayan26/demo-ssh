package com.example.demo.infrastructure.inerfaces.command;

import com.example.demo.application.command.run.RunCommandStartService;
import com.example.demo.application.command.stop.RunCommandStopService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Run service")
@RestController
@RequestMapping("/command")
@CrossOrigin("*")
public class CommandRestController implements ICommandRestController {

    @Autowired
    RunCommandStartService commandStartService;

    @Autowired
    RunCommandStopService commandStopService;

    @Override
    public ResponseEntity<?> runService() {
        return ResponseEntity.ok(commandStartService.run());
    }

    @Override
    public ResponseEntity<?> stopService() {
        return ResponseEntity.ok(commandStopService.stop());
    }
}
