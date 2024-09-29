package com.fatec.ace.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String nome;
	@Column(nullable = false)
	String email;
	@Column
	String setor;
	@Column
	String cargo;
	@Column(nullable = false)
	String telefone;
	@ManyToMany(mappedBy = "usuarios")
    Set<Conversa> conversas;
	@OneToMany(mappedBy = "usuario")
	Set<GrupoUsuario> grupos;
	@OneToMany(mappedBy = "usuario")
	Set<CanalUsuario> canais;

}
