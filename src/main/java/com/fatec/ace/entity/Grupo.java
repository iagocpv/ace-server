package com.fatec.ace.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@RequiredArgsConstructor
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String nome;
	@Column
	String descricao;
	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	Set<GrupoUsuario> usuarios = new HashSet<GrupoUsuario>();
	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
	Set<Canal> canais = new HashSet<Canal>();
	
	public Grupo update(Grupo novosValores) {
		setNome(novosValores.getNome());
		return this;
	}
	public Grupo addUsuario(Usuario usuario, boolean admin) {
		this.usuarios.add(new GrupoUsuario(this, usuario, admin));
		return this;
	}
	public void removeUsuario(Usuario usuario) {
		this.usuarios = this.usuarios
				.stream()
				.filter(u -> u.getUsuario() != usuario)
				.collect(Collectors.toSet());
	}
	public void addCanal(Canal canal) {
		this.canais.add(canal);
	}
	public void removeCanal(Canal canal) {
		this.canais = this.canais
				.stream()
				.filter(c -> c != canal)
				.collect(Collectors.toSet());
	}
}
