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

import com.crud.apirest.models.Produto;
import com.crud.apirest.service.ProdutoService;

@RestController
@RequestMapping(value="api")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoService.findAll();		
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<?> listaProduto(@PathVariable(value="id") long id) {
		Produto prod = produtoService.findById(id);
		if (prod==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prod);
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoService.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoService.save(produto);		
	}
	
}
