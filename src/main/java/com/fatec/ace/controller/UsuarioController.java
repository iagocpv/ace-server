package com.fatec.ace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.ace.entity.Usuario;
import com.fatec.ace.model.info.UsuarioBasicInfo;
import com.fatec.ace.model.info.UsuarioFullInfo;
import com.fatec.ace.model.mapper.UsuarioMapper;
import com.fatec.ace.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioBasicInfo> getUsuarios() {
		return UsuarioMapper.toBasicInfo(usuarioService.buscarTodos()) ;
	}
	@GetMapping("/{id}")
	public UsuarioFullInfo getUsuario(@PathVariable("id") Long id) {
		return UsuarioMapper.toFullInfo(usuarioService.buscarPorId(id));
	}
	@PostMapping
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		return usuarioService.criar(usuario);
	}
	@PutMapping("/{id}")
	public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
		return usuarioService.atualizar(id, usuario);
	}
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		usuarioService.deletar(id);
	}
}
