package com.example.demo.domain.ssh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SshParams {
    private String username;
    private String password;
    private String host;
    private int port;
}
