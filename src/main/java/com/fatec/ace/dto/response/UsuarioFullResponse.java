package com.fatec.ace.dto.response;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioFullResponse extends UsuarioResponse {
	public UsuarioFullResponse(Long id, String nome, String email, String setor, String cargo, String telefone, List<GrupoResponse> grupos) {
		super(id, nome, email, setor, cargo, telefone);
		this.grupos = grupos;
	}
	
	List<GrupoResponse> grupos;
}
