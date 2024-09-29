package com.fatec.ace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class GrupoUsuarioId {		
	@Column
	Long grupoId;	
	@Column
	Long usuarioId;
}