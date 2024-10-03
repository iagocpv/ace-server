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

import com.fatec.ace.entity.Canal;
import com.fatec.ace.model.form.CanalForm;
import com.fatec.ace.service.CanalService;

@RestController
@RequestMapping("/canais")
@CrossOrigin("*")
public class CanalController {

	@Autowired
	private CanalService canalService;
	
	@GetMapping
	public List<Canal> getCanais() {
		return canalService.buscarTodos();
	}
	@GetMapping("/{id}")
	public Canal getCanal(@PathVariable("id") Long id) {
		return canalService.buscarPorId(id);
	}
	@PostMapping
	public Canal createCanal(@RequestBody CanalForm canalForm) {
		return canalService.criar(canalForm);
	}
	@PutMapping("/{id}")
	public Canal updateCanal(@PathVariable("id") Long id, @RequestBody Canal canal) {
		return canalService.atualizar(id, canal);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCanal(@PathVariable("id") Long id) {
		canalService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
