package com.fatec.ace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fatec.ace.entity.Grupo;
import com.fatec.ace.model.info.GrupoFullInfo;
import com.fatec.ace.model.mapper.GrupoMapper;
import com.fatec.ace.service.GrupoService;

@RestController
@RequestMapping("/grupos")
@CrossOrigin("*")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@GetMapping
	public List<GrupoFullInfo> getGrupos() {
		return GrupoMapper.toFullInfo(grupoService.buscarTodos());
	}
	@GetMapping("/{id}")
	public GrupoFullInfo getGrupo(@PathVariable("id") Long id) {
		return GrupoMapper.toFullInfo(grupoService.buscarPorId(id));
	}
	@PostMapping
	public Grupo createGrupo(@RequestBody Grupo grupo) {
		return grupoService.criar(grupo);
	}
	@PutMapping("/{id}")
	public Grupo updateGrupo(@PathVariable("id") Long id, @RequestBody Grupo grupo) {
		return grupoService.atualizar(id, grupo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGrupo(@PathVariable("id") Long id) {
		grupoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	@PostMapping("/{id}/adicionarUsuario")
	public void addUsuario(@PathVariable("id") Long id, @RequestBody ObjectNode json) {
		grupoService.addUsuario(id, json.get("idUsuario").asLong(), json.get("admin").asBoolean());
	}
	
}