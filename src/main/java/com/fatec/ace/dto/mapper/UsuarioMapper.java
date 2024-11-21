package com.fatec.ace.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.ace.dto.response.UsuarioResponse;
import com.fatec.ace.dto.response.UsuarioFullResponse;
import com.fatec.ace.entity.Usuario;

public class UsuarioMapper {
	
	public static UsuarioResponse toResponse(Usuario usuario) {
		return new UsuarioResponse(
					usuario.getId(),
					usuario.getNome(),
					usuario.getEmail(),
					usuario.getSetor(),
					usuario.getCargo(),
					usuario.getTelefone()
				);
	}
	
	public static UsuarioFullResponse toFullResponse(Usuario usuario) {
		return new UsuarioFullResponse(
					usuario.getId(),
					usuario.getNome(),
					usuario.getEmail(),
					usuario.getSetor(),
					usuario.getCargo(),
					usuario.getTelefone(),
					GrupoMapper.toResponse(
							usuario.getGrupos()
								.stream()
								.map(grupoUsuario -> grupoUsuario.getGrupo())
								.collect(Collectors.toList())
							)					
				);
	}
	
	public static List<UsuarioResponse> toResponse(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(usuario -> toResponse(usuario))
				.collect(Collectors.toList());		
}
	
	public static List<UsuarioFullResponse> toFullResponse(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(usuario -> toFullResponse(usuario))
				.collect(Collectors.toList());
	}
	

}
