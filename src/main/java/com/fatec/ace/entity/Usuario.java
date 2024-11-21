package com.fatec.ace.entity;

import java.util.HashSet;
import java.util.Set;

import com.fatec.ace.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(nullable = false)
	String nome;
	@Column(nullable = false, unique = true)
	String email;
	@Column
	String senha;
	@Column
	String setor;
	@Column
	String cargo;
	@Column(nullable = false)
	String telefone;
	@ManyToMany(mappedBy = "usuarios")
    Set<Conversa> conversas = new HashSet<Conversa>();
	@OneToMany(mappedBy = "usuario")
	Set<GrupoUsuario> grupos  = new HashSet<GrupoUsuario>();
	@OneToMany(mappedBy = "usuario")
	Set<CanalUsuario> canais  = new HashSet<CanalUsuario>();
	@ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "role")
    Set<Role> roles = new HashSet<>();
	
	public Usuario update(Usuario novosValores) {
		setNome(novosValores.getNome());
		setEmail(novosValores.getEmail());
		setSetor(novosValores.getSetor());
		setCargo(novosValores.getCargo());
		setTelefone(novosValores.getTelefone());
		return this;
	}
	
	public void addGrupo(GrupoUsuario grupo) {
		this.grupos.add(grupo);
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}

}
