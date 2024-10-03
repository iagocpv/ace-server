package com.fatec.ace.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RequiredArgsConstructor
public class Canal {
	public Canal(String nome, Grupo grupo) {
		this.nome = nome;
		this.grupo = grupo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String nome;
	@OneToMany(mappedBy="canal")
	Set<CanalUsuario> usuarios = new HashSet<CanalUsuario>();
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="grupo_id", nullable=false)
	Grupo grupo;
	
	public Canal update(Canal novosValores) {
		setNome(novosValores.getNome());
		return this;
	}

}
