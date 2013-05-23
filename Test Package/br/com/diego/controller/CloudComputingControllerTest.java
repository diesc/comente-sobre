/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.controller;

import static org.junit.Assert.*;

import br.com.diego.dao.ComentarioDAO;
import br.com.diego.model.Comentario;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego Classe que testa o funcionamento da classe controller
 * CloudComputingController
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {" file:web/WEB-INF/applicationContextTest.xml"})
public class CloudComputingControllerTest {

    @Autowired
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;
    @Autowired
    private CloudComputingController controller;
    private ModelMap model;

    /**
     * Configurando as instâncias de entrada de dados da classe Comentario
     * Implementando a classe ModelMap
     */
    @Before
    public void setUp() {
        model = new ExtendedModelMap();
        comentario = new Comentario("Teste", "teste@teste.com", "Cloud");
    }

    /**
     * Testa o método mostrarPagina da classe: CloudComputingController
     */
    @Test
    public void testMostrarPagina() {

        comentarioDAO.adicionar(comentario);

        List comentarios = (List<Comentario>) model.get("listar");

        ModelAndView view = controller.mostrarPagina(model);
        assertEquals("pagina-cloud-computing", view.getViewName());
        assertNotNull(view.getModelMap().get("comentario"));
        assertFalse(view.getModelMap().containsValue(comentarios));
    }

    /**
     * Testa o método adicionarComentario da classe: CloudComputingController
     */
    @Test
    public void testAdicionarComentario() {

        ModelAndView view = controller.adicionarComentario(comentario);
        assertEquals("redirect:cloud-computing.htm", view.getViewName());
        assertFalse(view.getModelMap().containsValue(comentario));


    }
}
