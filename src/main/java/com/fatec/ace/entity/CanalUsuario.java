package com.fatec.ace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CanalUsuario {
	@EmbeddedId
	CanalUsuarioId id = new CanalUsuarioId();
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("canalId")
	Canal canal;
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
	Usuario usuario;	
	@Column
	boolean admin;
}
