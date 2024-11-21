package com.fatec.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fatec.ace.entity.Usuario;
import com.fatec.ace.enums.Role;
import com.fatec.ace.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario criar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuario.addRole(Role.USER);
		return repository.save(usuario);
	}
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}	
	public Usuario buscarPorId(Long id) {
		return repository.findById(id).get();
	}
	public void deletar(Long id) {
		repository.findById(id).orElseThrow();
		repository.deleteById(id);
	}
	public Usuario atualizar(Long id, Usuario novosValores) {
		Usuario usuario = this.buscarPorId(id);
		return repository.save(usuario.update(novosValores));
	}
}
