package com.fatec.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.ace.entity.Usuario;
import com.fatec.ace.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario criar(Usuario usuario) {
		return repository.save(usuario);
	}
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}	
	public Usuario buscarPorId(Long id) {
		return repository.findById(id).get();
	}
	public ResponseEntity<Object> deletar(Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	public Usuario atualizar(Long id, Usuario novosValores) {
		Usuario usuario = this.buscarPorId(id);
		return repository.save(usuario.update(novosValores));
	}
}
