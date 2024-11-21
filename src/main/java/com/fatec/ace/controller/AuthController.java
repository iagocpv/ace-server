package com.fatec.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.ace.dto.request.LoginRequest;
import com.fatec.ace.entity.Usuario;
import com.fatec.ace.repository.UsuarioRepository;
import com.fatec.ace.security.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha())
        );
        
        Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail()).get();

        return jwtTokenUtil.generateToken(usuario.getEmail(), usuario.getRoles(), usuario.getId());
    }
}
