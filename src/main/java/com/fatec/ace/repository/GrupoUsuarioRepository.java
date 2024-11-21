package com.fatec.ace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.ace.entity.GrupoUsuario;
import com.fatec.ace.entity.GrupoUsuarioId;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, GrupoUsuarioId> {

    GrupoUsuario findByGrupoIdAndUsuarioEmail(Long grupoId, String email);
}
