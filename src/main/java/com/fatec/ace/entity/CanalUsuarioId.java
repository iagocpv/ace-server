package com.fatec.ace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class CanalUsuarioId {		
	@Column
	Long canalId;	
	@Column
	Long usuarioId;
}
