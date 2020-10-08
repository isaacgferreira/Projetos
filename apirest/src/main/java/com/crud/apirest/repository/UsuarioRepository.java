package com.crud.apirest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.crud.apirest.models.Usuario;


@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
//	@Query("select u from tb_usuario u where u.login = :login")
//	Usuario getUsuario(@Param("login") String login);
	@Autowired
	Usuario findByLogin(String login);

	Usuario findById(long id);

}
