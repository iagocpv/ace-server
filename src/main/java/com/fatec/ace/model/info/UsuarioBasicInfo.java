package com.fatec.ace.model.info;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioBasicInfo {
	Long id;
	String nome;
	String email;
	String setor;
	String cargo;
	String telefone;
}
