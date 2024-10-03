package com.fatec.ace.model.info;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GrupoUsuarioInfo extends UsuarioBasicInfo {
	
	public GrupoUsuarioInfo(Long id, String nome, String email, String setor, String cargo, String telefone, boolean admin) {
		super(id, nome, email, setor, cargo, telefone);
		this.admin = admin;
	}
	
	boolean admin;
}
