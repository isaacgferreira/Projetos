package com.crud.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.crud.apirest.models.Produto;
import com.crud.apirest.repository.ProdutoRepository;

@Service
@Configurable
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoReposity;
	
	public List<Produto> findAll() {
		return produtoReposity.findAll();		
	}

	public Produto findById(long id) {
		return produtoReposity.findById(id);
	}

	public Produto save(Produto produto) {
		return produtoReposity.save(produto);
	}

	public void delete(Produto produto) {
		produtoReposity.delete(produto);
	}

}
