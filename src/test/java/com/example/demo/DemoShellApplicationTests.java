package com.example.demo;

import com.example.demo.domain.ssh.SshParams;
import com.example.demo.infrastructure.services.ssh.SshConnectService;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
class DemoShellApplicationTests {
	private static final String COMMAND="ls -l ~/colombia/";
	private static final String USERNAME="nor";
	private static final String PASSWORD="goteras";
	private static final String HOST = "172.30.223.20";
	private static final int PORT = 22;

	@Autowired
	SshConnectService service;

	private SshParams params;

	@BeforeEach
	void createParams() {
		params = new SshParams();
		params.setUsername(USERNAME);
		params.setHost(HOST);
		params.setPort(PORT);
		params.setPassword(PASSWORD);
	}

	@Test
	void contextLoads() throws JSchException, IOException, IllegalAccessException {
		//Access console
		Session ssh = service.connect(params);
		//Exec command ls -lha
		String response = service.executeCommand(ssh, COMMAND);
		//Close console
		ssh.disconnect();
		Assertions.assertNotNull(response, "Ssh response is null..!");
		log.info(response);
	}
}
