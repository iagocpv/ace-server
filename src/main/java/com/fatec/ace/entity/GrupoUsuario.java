package com.fatec.ace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class GrupoUsuario {
	
	public GrupoUsuario(Grupo grupo, Usuario usuario, boolean admin) {
		this.grupo = grupo;
		this.usuario = usuario;
		this.admin = admin;
		this.usuario.addGrupo(this);
	}
	
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
	
	public void removeGrupoUsuario(GrupoUsuario grupoUsuario) {
		usuario.getGrupos().remove(this);
	}
	
	public boolean isAdmin() {
	    return this.admin;
	}


}
