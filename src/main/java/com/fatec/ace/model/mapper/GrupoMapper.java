package com.fatec.ace.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fatec.ace.entity.Grupo;
import com.fatec.ace.model.info.GrupoBasicInfo;
import com.fatec.ace.model.info.GrupoFullInfo;

public class GrupoMapper {
	
	public static GrupoBasicInfo toBasicInfo(Grupo grupo) {
		return new GrupoBasicInfo(
				grupo.getId(),
				grupo.getNome(),
				grupo.getDescricao()
			);
	}
	
	public static List<GrupoBasicInfo> toBasicInfo(List<Grupo> grupoCollection) {
		return grupoCollection
				.stream()
				.map(grupo -> toBasicInfo(grupo))
				.collect(Collectors.toList());	
	}
	
	public static GrupoFullInfo toFullInfo(Grupo grupo) {
		return new GrupoFullInfo(
					grupo.getId(),
					grupo.getNome(),
					grupo.getDescricao(),
					GrupoUsuarioMapper.toInfo(grupo.getUsuarios()),
					grupo.getCanais()
				);
	}
	
	public static List<GrupoFullInfo> toFullInfo(List<Grupo> grupoCollection) {
		return grupoCollection
				.stream()
				.map(grupo -> toFullInfo(grupo))
				.collect(Collectors.toList());	
	}

}
