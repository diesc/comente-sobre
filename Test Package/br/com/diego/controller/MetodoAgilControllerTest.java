/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.controller;

import br.com.diego.dao.ComentarioDAO;
import br.com.diego.model.Comentario;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author disou_000
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContextTest.xml"})
public class MetodoAgilControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Mock
    View mockView;
    @InjectMocks
    MetodoAgilController metodoAgilController;
    @Mock
    private ComentarioDAO mockComentarioDAO;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(metodoAgilController)
                .setSingleView(mockView)
                .build();

        List<Comentario> comentarios = new ArrayList<Comentario>();
        Comentario primeiroComentario = new Comentario();
        primeiroComentario.setCdCliente(Integer.SIZE);

        Comentario segundoComentario = new Comentario();
        segundoComentario.setCdCliente(Integer.SIZE);

        comentarios.add(primeiroComentario);
        comentarios.add(segundoComentario);

        Mockito.when(mockComentarioDAO.listar()).thenReturn(comentarios);

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testMostrarPagina() throws Exception {
       
        List<Comentario> comentarios = new ArrayList<Comentario>();
        Comentario primeiroComentario = new Comentario();
        primeiroComentario.setCdCliente(Integer.SIZE);

        Comentario segundoComentario = new Comentario();
        segundoComentario.setCdCliente(Integer.SIZE);
               
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/metodo-agil");
       
        this.mockMvc.perform(requestBuilder).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.model().attribute("listar", comentarios)).
                andExpect(MockMvcResultMatchers.model().size(2)).
                andExpect(MockMvcResultMatchers.view().name("pagina-metodos-ageis"));
       

    }
}