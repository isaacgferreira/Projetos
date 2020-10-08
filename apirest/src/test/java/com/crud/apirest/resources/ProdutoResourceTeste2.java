package com.crud.apirest.resources;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.crud.apirest.controllers.ProdutoController;
import com.crud.apirest.models.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoResourceTeste2 {

	@Autowired
	private MockMvc mvc;
	
    @MockBean
    private ProdutoController produtoResource;

	@Test
//	@WithMockUser(username = "root", authorities = {"ADMIN"})
	public void testaGetProdutoId() throws Exception {
		
//	    PageRequest paginacao = PageRequest.of(1, 10);
//	    List<Produto> produtos = Arrays.asList(new Produto(), new Produto());
//	    Page<Produto> centrosDeCustosPage = new PageImpl<>(produtos, paginacao, produtos.size());
//
//	    given(produtoResource.departamentosPorDataDeAtualizacao(paginacao)).willReturn(centrosDeCustosPage);
//
//	    mvc.perform(get("/centrosdecustos").contentType(MediaType.APPLICATION_JSON))
//	            .andExpect(status().isOk());
//		
//		
		
		
		
		String uri = "/api/produto/1";
//        List<Produto> result = new ArrayList();
		Produto produto = createProduto();
		produto = produtoResource.salvaProduto(produto);
//		result.add(produto);
		if (produto == null) {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAaa");
			
		}
//		given()).willReturn(produto);
		Mockito.when(produtoResource.salvaProduto(Mockito.any(Produto.class))).thenReturn(produto);
		this.mvc.perform(get(uri))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(content().string(containsString("Teste")));
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
