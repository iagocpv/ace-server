package com.fatec.ace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fatec.ace.entity.GrupoUsuario;
import com.fatec.ace.repository.GrupoUsuarioRepository;

@Service
public class SecurityService {

    @Autowired
    private GrupoUsuarioRepository grupoUsuarioRepository;

    public boolean isUserAdminOfGroup(Long grupoId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();

        GrupoUsuario grupoUsuario = grupoUsuarioRepository.findByGrupoIdAndUsuarioEmail(grupoId, username);

        return grupoUsuario != null && grupoUsuario.isAdmin();
    }
}
