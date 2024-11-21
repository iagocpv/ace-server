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

import com.fatec.ace.dto.response.UsuarioResponse;
import com.fatec.ace.dto.mapper.UsuarioMapper;
import com.fatec.ace.dto.response.UsuarioFullResponse;
import com.fatec.ace.entity.Usuario;
import com.fatec.ace.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioResponse> getUsuarios() {
		return UsuarioMapper.toResponse(usuarioService.buscarTodos()) ;
	}
	@GetMapping("/{id}")
	public UsuarioFullResponse getUsuario(@PathVariable("id") Long id) {
		return UsuarioMapper.toFullResponse(usuarioService.buscarPorId(id));
	}
	@PostMapping("/cadastrar")
	public UsuarioResponse createUsuario(@RequestBody Usuario usuario) {
		return UsuarioMapper.toResponse(usuarioService.criar(usuario));
	}
	@PutMapping("/{id}")
	public UsuarioResponse updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		return UsuarioMapper.toResponse(usuarioService.atualizar(id, usuario));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id) {
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
