package com.example.demo.application.command.stop;

import com.example.demo.domain.ssh.SshParams;
import com.example.demo.domain.ssh.SshResponse;
import com.example.demo.infrastructure.services.ssh.SshConnectService;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunCommandStopService {
    private static final String COMMAND = "helm uninstall spv-space";
    @Value("${ssh.username}")
    String username;
    @Value("${ssh.password}")
    String password;
    @Value("${ssh.host}")
    String host;
    @Value("${ssh.port}")
    int port;

    @Autowired
    SshConnectService service;

    public SshResponse stop() {
        SshParams params = new SshParams(username, password,host, port);
        //Connect to shell
        Session session = service.connect(params);
        //run command
        String response = service.executeCommand(session, COMMAND);
        //Response
        return new SshResponse(response);
    }
}
