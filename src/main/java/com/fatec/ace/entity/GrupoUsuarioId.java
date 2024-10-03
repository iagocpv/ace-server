package com.fatec.ace.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Embeddable
@EqualsAndHashCode
public class GrupoUsuarioId implements Serializable{		
	@Column
	Long grupoId;
	@Column
	Long usuarioId;
}