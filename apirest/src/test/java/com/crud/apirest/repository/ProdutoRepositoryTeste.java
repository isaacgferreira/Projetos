package com.crud.apirest.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.any;

import com.crud.apirest.controllers.ProdutoController;
import com.crud.apirest.models.Produto;
import com.crud.apirest.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTeste {

//	@MockBean
//	private ProdutoRepository produtoReposity;

	@Mock
//	(answer = Answers.RETURNS_SELF)
//	@InjectMocks
	private ProdutoService prodRepo;
	
//	@Before
//	public void setup () {
//		prodRepo = new ProdutoServiceImpl(produtoReposity);
//	}
	
	@Test
	public void testaProdutoNotNull () {

//		ProdutoRepository prodRepo = Mockito.mock(ProdutoRepository.class);
		
		Produto produto = createProduto();
		
		Mockito.when(prodRepo.findById(Mockito.anyLong())).thenReturn(produto);

//		prodRepo = Mockito.mock(ProdutoRepository.class);
		Produto prodEsperado = prodRepo.findById(1l);
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		System.out.println(prodEsperado.getIdentificador().toString());
		System.out.println(prodEsperado.getNome());
		
//		List<Produto> produtos = prodRepo.findAll();
//		Optional<Produto> prod = prodRepo.findById(id);
//		assertNotNull(prodEsperado);
		assertEquals(prodEsperado, produto);
		
	}

    private Produto createProduto() {
    	Produto prod = new Produto();
    	prod.setIdentificador(1l);
    	prod.setNome("Teste");
    	prod.setQuantidade(100d);
    	prod.setValor(5d);
//    	prod = prodRepo.save(prod);
    	return prod;
	}
	
}
