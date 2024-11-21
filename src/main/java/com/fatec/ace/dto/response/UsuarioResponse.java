package com.fatec.ace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioResponse {
	Long id;
	String nome;
	String email;
	String setor;
	String cargo;
	String telefone;
}
