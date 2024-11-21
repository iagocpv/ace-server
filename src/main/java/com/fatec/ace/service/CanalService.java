package com.fatec.ace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ace.dto.request.CanalRequest;
import com.fatec.ace.entity.Canal;
import com.fatec.ace.entity.Grupo;
import com.fatec.ace.repository.CanalRepository;

@Service
public class CanalService {
	
	@Autowired
	private CanalRepository repository;
	@Autowired
	private GrupoService grupoService;

	public List<Canal> buscarTodos() {
		return repository.findAll();
	}
	public Canal buscarPorId(Long id) {
		return repository.findById(id).get();
	}
	public Canal criar(CanalRequest canal) {
		Grupo grupo = grupoService.buscarPorId(canal.getIdGrupo());
		return repository.save(new Canal(canal.getNome(), grupo));
	}
	public Canal atualizar(Long id, Canal novosValores) {
		Canal canal = this.buscarPorId(id);
		return repository.save(canal.update(novosValores));
	}
	public void deletar(Long id) {
		repository.deleteById(id);
	}

}
