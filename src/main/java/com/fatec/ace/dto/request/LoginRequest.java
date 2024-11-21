package com.fatec.ace.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;
}
