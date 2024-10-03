package com.fatec.ace.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.ace.entity.Usuario;
import com.fatec.ace.model.info.UsuarioBasicInfo;
import com.fatec.ace.model.info.UsuarioFullInfo;

public class UsuarioMapper {
	
	public static UsuarioBasicInfo toBasicInfo(Usuario usuario) {
		return new UsuarioBasicInfo(
					usuario.getId(),
					usuario.getNome(),
					usuario.getEmail(),
					usuario.getSetor(),
					usuario.getCargo(),
					usuario.getTelefone()
				);
	}
	
	public static UsuarioFullInfo toFullInfo(Usuario usuario) {
		return new UsuarioFullInfo(
					usuario.getId(),
					usuario.getNome(),
					usuario.getEmail(),
					usuario.getSetor(),
					usuario.getCargo(),
					usuario.getTelefone(),
					GrupoMapper.toBasicInfo(
							usuario.getGrupos()
								.stream()
								.map(grupoUsuario -> grupoUsuario.getGrupo())
								.collect(Collectors.toList())
							)					
				);
	}
	
	public static List<UsuarioBasicInfo> toBasicInfo(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(usuario -> toBasicInfo(usuario))
				.collect(Collectors.toList());		
}
	
	public static List<UsuarioFullInfo> toFullInfo(List<Usuario> usuarios) {
		return usuarios
				.stream()
				.map(usuario -> toFullInfo(usuario))
				.collect(Collectors.toList());
	}
	

}
