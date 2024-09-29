package com.fatec.ace.model;

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
public class GrupoUsuario {
	@EmbeddedId
	GrupoUsuarioId id = new GrupoUsuarioId();	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
	Usuario usuario;	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("grupoId")
	Grupo grupo;
	@Column
	boolean admin;

}
