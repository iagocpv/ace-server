package com.fatec.ace.dto.response;

import java.util.Set;

import com.fatec.ace.entity.Canal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GrupoFullResponse extends GrupoResponse {
	
	public GrupoFullResponse(Long id, String nome, String descricao, Set<GrupoUsuarioResponse> usuarios, Set<Canal> canais) {
		super(id, nome, descricao);
		this.usuarios = usuarios;
	}
	
	Set<GrupoUsuarioResponse> usuarios;

}
