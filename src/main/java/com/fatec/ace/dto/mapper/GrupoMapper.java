package com.fatec.ace.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.ace.dto.response.GrupoResponse;
import com.fatec.ace.dto.response.GrupoFullResponse;
import com.fatec.ace.entity.Grupo;

public class GrupoMapper {
	
	public static GrupoResponse toResponse(Grupo grupo) {
		return new GrupoResponse(
				grupo.getId(),
				grupo.getNome(),
				grupo.getDescricao()
			);
	}
	
	public static List<GrupoResponse> toResponse(List<Grupo> grupoCollection) {
		return grupoCollection
				.stream()
				.map(grupo -> toResponse(grupo))
				.collect(Collectors.toList());	
	}
	
	public static GrupoFullResponse toFullResponse(Grupo grupo) {
		return new GrupoFullResponse(
					grupo.getId(),
					grupo.getNome(),
					grupo.getDescricao(),
					GrupoUsuarioMapper.toResponse(grupo.getUsuarios()),
					grupo.getCanais()
				);
	}
	
	public static List<GrupoFullResponse> toFullResponse(List<Grupo> grupoCollection) {
		return grupoCollection
				.stream()
				.map(grupo -> toFullResponse(grupo))
				.collect(Collectors.toList());	
	}

}
