package com.crud.apirest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.crud.apirest.controllers.ProdutoController;
import com.crud.apirest.models.Produto;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(ProdutoController.class)
public class ProdutoResourceTeste_ {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoController produtoResource;

    @Test
    public void callingWithoutParameterShouldReturnBadRequest() throws Exception {
        //List<Produto> result = new ArrayList<>();
        Produto prod = createProduto();
        Mockito.when(produtoResource.salvaProduto(prod)).thenReturn(prod);
        this.mockMvc.perform(get("api/produto/1"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

//	@Test
//    public void shouldReturnJustOneFromResult() throws Exception {
//        List<Produto> result = new ArrayList<>();
//        result.add(createProduto());
////        Mockito.when(produtoResource.salvaProduto(createProduto())).thenReturn(result);
//        Mockito.when(produtoResource.salvaProduto(createProduto()));
//        this.mockMvc.perform(get("/stocks").queryParam("howMany", "1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().string(containsString("NEWSTOCK")));
//    }

    private Produto createProduto() {
    	Produto prod = new Produto();
    	prod.setIdentificador(1l);
    	prod.setNome("Teste");
    	prod.setQuantidade(100d);
    	prod.setValor(5d);
    	return prod;
	}

}
