package com.fatec.ace.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GrupoUsuarioResponse extends UsuarioResponse {
	
	public GrupoUsuarioResponse(Long id, String nome, String email, String setor, String cargo, String telefone, boolean admin) {
		super(id, nome, email, setor, cargo, telefone);
		this.admin = admin;
	}
	
	boolean admin;
}
