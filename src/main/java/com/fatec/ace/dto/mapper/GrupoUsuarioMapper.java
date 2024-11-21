package com.fatec.ace.dto.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.fatec.ace.dto.response.GrupoUsuarioResponse;
import com.fatec.ace.entity.GrupoUsuario;
import com.fatec.ace.entity.Usuario;

public class GrupoUsuarioMapper {
	
	public static GrupoUsuarioResponse toResponse(GrupoUsuario grupoUsuario) {
		Usuario usuario = grupoUsuario.getUsuario();
		return new GrupoUsuarioResponse(
				usuario.getId(),
				usuario.getNome(),
				usuario.getEmail(),
				usuario.getSetor(),
				usuario.getCargo(),
				usuario.getTelefone(),
				grupoUsuario.isAdmin()			
			);
	}
	
	public static Set<GrupoUsuarioResponse> toResponse(Set<GrupoUsuario> grupoUsuarioCollection) {
		return grupoUsuarioCollection
			.stream()
			.map(grupoUsuario -> {
				return toResponse(grupoUsuario);
			})
			.collect(Collectors.toSet());				
	}
}
