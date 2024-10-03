package com.fatec.ace.model.info;

import java.util.Set;

import com.fatec.ace.entity.Canal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GrupoFullInfo extends GrupoBasicInfo {
	
	public GrupoFullInfo(Long id, String nome, String descricao, Set<GrupoUsuarioInfo> usuarios, Set<Canal> canais) {
		super(id, nome, descricao);
		this.usuarios = usuarios;
	}
	
	Set<GrupoUsuarioInfo> usuarios;

}
