package com.fatec.ace.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.fatec.ace.entity.GrupoUsuario;
import com.fatec.ace.entity.Usuario;
import com.fatec.ace.model.info.GrupoUsuarioInfo;

public class GrupoUsuarioMapper {
	
	public static GrupoUsuarioInfo toInfo(GrupoUsuario grupoUsuario) {
		Usuario usuario = grupoUsuario.getUsuario();
		return new GrupoUsuarioInfo(
				usuario.getId(),
				usuario.getNome(),
				usuario.getEmail(),
				usuario.getSetor(),
				usuario.getCargo(),
				usuario.getTelefone(),
				grupoUsuario.isAdmin()			
			);
	}
	
	public static Set<GrupoUsuarioInfo> toInfo(Set<GrupoUsuario> grupoUsuarioCollection) {
		return grupoUsuarioCollection
			.stream()
			.map(grupoUsuario -> {
				return toInfo(grupoUsuario);
			})
			.collect(Collectors.toSet());				
	}
}
