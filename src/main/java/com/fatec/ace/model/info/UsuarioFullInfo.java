package com.fatec.ace.model.info;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioFullInfo extends UsuarioBasicInfo {
	public UsuarioFullInfo(Long id, String nome, String email, String setor, String cargo, String telefone, List<GrupoBasicInfo> grupos) {
		super(id, nome, email, setor, cargo, telefone);
		this.grupos = grupos;
	}
	
	List<GrupoBasicInfo> grupos;
}
