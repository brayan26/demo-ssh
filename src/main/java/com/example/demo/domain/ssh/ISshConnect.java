package com.example.demo.domain.ssh;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public interface ISshConnect {
    Session connect(SshParams sshParams) throws JSchException;
    String executeCommand(Session session, String command);
}
