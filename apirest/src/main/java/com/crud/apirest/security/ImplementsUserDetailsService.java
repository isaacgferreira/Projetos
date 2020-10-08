package com.crud.apirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.crud.apirest.models.Usuario;
import com.crud.apirest.repository.UsuarioRepository;

public class ImplementsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Override
	public UsuarioDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario usuario = usuarioRep.findByLogin(login);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}

		return new UsuarioDetails(usuario);
	}
	
	

}
