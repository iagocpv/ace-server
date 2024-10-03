package com.fatec.ace.model.info;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrupoBasicInfo {
	Long id;
	String nome;
	String descricao;
}
