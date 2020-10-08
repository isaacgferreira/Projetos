package com.crud.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.apirest.models.Usuario;
import com.crud.apirest.repository.UsuarioRepository;

@Service
@Configurable
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();		
	}

	public Usuario findById(long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario save(Usuario usuario) {
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

}
