package com.crud.apirest.resources;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.crud.apirest.controllers.ProdutoController;
import com.crud.apirest.models.Produto;


import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebMvcTest(ProdutoResource.class)
@WebMvcTest
public class ProdutoResourceTeste {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProdutoController produtoResource;
	
//	@Autowired
//	public WebApplicationContext context;
//	
//	private MockMvc mvc;
//	
//    @MockBean
//    private ProdutoResource produtoResource;
//	
//	@Before
//	public void setup () {
//		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//	}
	
	@Test
//	@WithMockUser(username = "root", authorities = {"ADMIN"})
	public void testaGetProdutoId() throws Exception {
		String uri = "http://localhost:8080/api/produto/1";
//        List<Produto> result = new ArrayList();
		Produto produto = createProduto();
//		produto = produtoResource.salvaProduto(produto);
//		result.add(produto);
		if (produto == null) {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			
		}
		Mockito.when(produtoResource.salvaProduto(Mockito.any(Produto.class))).thenReturn(produto);
		this.mvc.perform(get(uri))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

    private Produto createProduto() {
    	Produto prod = new Produto();
    	prod.setIdentificador(1l);
    	prod.setNome("Teste");
    	prod.setQuantidade(100d);
    	prod.setValor(5d);
    	return prod;
	}

}
