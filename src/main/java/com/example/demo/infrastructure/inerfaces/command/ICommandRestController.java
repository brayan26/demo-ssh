package com.example.demo.infrastructure.inerfaces.command;

import com.example.demo.domain.ssh.SshResponse;
import com.example.demo.infrastructure.utils.Error400Exception;
import com.example.demo.infrastructure.utils.Error404Exception;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


public interface ICommandRestController {
    @ApiOperation(value = "SshResponse", notes = "Run command in remote server", response = SshResponse.class,
            responseContainer = "Single SshResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of AddressLocation Fetched", response = SshResponse.class, responseContainer = "SshResponse"),
            @ApiResponse(code = 500, message = "Unexpected error", response = Exception.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error400Exception.class),
            @ApiResponse(code = 404, message = "Not found", response = Error404Exception.class)
    })
    @PostMapping(value = "/runService", produces = {"application/json"})
    ResponseEntity<?> runService();

    @ApiOperation(value = "SshResponse", notes = "Run command in remote server", response = SshResponse.class,
            responseContainer = "Single SshResponse")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of AddressLocation Fetched", response = SshResponse.class, responseContainer = "SshResponse"),
            @ApiResponse(code = 500, message = "Unexpected error", response = Exception.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error400Exception.class),
            @ApiResponse(code = 404, message = "Not found", response = Error404Exception.class)
    })
    @PostMapping(value = "/stopService", produces = {"application/json"})
    ResponseEntity<?> stopService();
}
