package com.example.demo.infrastructure.services.ssh;

import com.example.demo.domain.ssh.ISshConnect;
import com.example.demo.domain.ssh.SshParams;
import com.example.demo.infrastructure.utils.Error400Exception;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import com.jcraft.jsch.ChannelExec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SshConnectService implements ISshConnect {
    private static final Logger log = LoggerFactory.getLogger(SshConnectService.class);
    private static final String ENTER_KEY = "\n";

    @Override
    public Session connect(SshParams sshParams) {
        try {
            JSch jsch = new JSch();
            log.info("Connecting to: {}", sshParams);
            Session session = jsch.getSession(sshParams.getUsername(), sshParams.getHost(), sshParams.getPort());
            session.setPassword(sshParams.getPassword());
            // Parametro para no validar key de conexion.
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            return session;
        } catch (JSchException e) {
            throw new Error400Exception(e.getMessage());
        }
    }

    @Override
    public String executeCommand(Session session, String command) {
        try {
            if (session == null || !session.isConnected()) {
                throw new IllegalAccessException("Ssh session is not initialized");
            }
            // open a SSH/console.
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

            InputStream in = channelExec.getInputStream();
            // Exec the command.
            log.info("Run command: {} in the server {}", command, session.getHost());
            channelExec.setCommand(command);
            channelExec.connect();
            // Get response.
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(ENTER_KEY);
            }
            // Close the channel SSH.
            channelExec.disconnect();
            return builder.toString();
        }catch (IllegalAccessException | IOException | JSchException e ) {
            log.error(e.getMessage());
            throw new Error400Exception(e.getMessage());
        }
    }
}
