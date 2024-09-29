package com.fatec.ace.model;

import java.util.Set;

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
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Conversa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@OneToMany(mappedBy = "conversa", fetch = FetchType.EAGER)
	Set<Mensagem> mensagens;
	@ManyToMany
    @JoinTable(name = "conversa_usuario",
            joinColumns = @JoinColumn(name = "conversa_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	Set<Usuario> usuarios;
}
