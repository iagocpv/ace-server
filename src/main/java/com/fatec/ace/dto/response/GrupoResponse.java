package com.fatec.ace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrupoResponse {
	Long id;
	String nome;
	String descricao;
}
