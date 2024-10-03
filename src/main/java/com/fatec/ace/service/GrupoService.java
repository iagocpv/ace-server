package com.fatec.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ace.entity.Grupo;
import com.fatec.ace.entity.Usuario;
import com.fatec.ace.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository repository;
	@Autowired
	private UsuarioService usuarioService;

	public List<Grupo> buscarTodos() {
		return repository.findAll();
	}
	public Grupo buscarPorId(Long id) {
		return repository.findById(id).get();
	}
	public Grupo criar(Grupo grupo) {
		return repository.save(grupo);
	}
	public Grupo atualizar(Long id, Grupo novosValores) {
		Grupo grupo = this.buscarPorId(id);
		return repository.save(grupo.update(novosValores));
	}
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	public void addUsuario(Long idGrupo, Long idUsuario, boolean admin) {
		Usuario usuario = usuarioService.buscarPorId(idUsuario);
		Grupo grupo = buscarPorId(idGrupo);
		repository.save(grupo.addUsuario(usuario, admin));
	}
	public void removeUsuario(Long idGrupo, Long idUsuario) {
		Usuario usuario = usuarioService.buscarPorId(idUsuario);
		Grupo grupo = buscarPorId(idGrupo);
		grupo.removeUsuario(usuario);
		repository.save(grupo);
	}

}