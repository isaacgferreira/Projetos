package com.crud.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.crud.apirest.models.Produto;

@Repository
@EnableJpaRepositories
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);

}
