package com.crud.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.apirest.models.Usuario;
import com.crud.apirest.service.UsuarioService;

@RestController
@RequestMapping(value="api")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> buscaUsuario(@PathVariable(value="id") long id) {
		Usuario usuario = usuarioService.findById(id);
		if (usuario==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@DeleteMapping("/usuario")
	public void deletaUsuario(@RequestBody Usuario usuario) {
		usuarioService.delete(usuario);
	}
	
	@PutMapping("/usuario")
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);		
	}
	
}
