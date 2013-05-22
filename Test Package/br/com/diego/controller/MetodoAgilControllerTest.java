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
 * @author disou_000
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {" file:web/WEB-INF/applicationContextTest.xml"})
public class MetodoAgilControllerTest {

    @Autowired
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;
    @Autowired
    private MetodoAgilController controller;
    private ModelMap model;

    @Before
    public void setUp() {
        model = new ExtendedModelMap();
        comentario = new Comentario("Teste", "teste@teste.com", "Testando!");
    }

    @Test
    public void testMostrarPagina() {

        comentarioDAO.adicionar(comentario);

        List comentarios = (List<Comentario>) model.get("listar");

        ModelAndView view = controller.mostrarPagina(model);
        assertEquals("pagina-metodos-ageis", view.getViewName());
        assertNotNull(view.getModelMap().get("comentario"));
        assertFalse(view.getModelMap().containsValue(comentarios));
    }

    @Test
    public void testAdicionarComentario() {

        ModelAndView view = controller.adicionarContato(comentario);
        assertEquals("redirect:metodo-agil.htm", view.getViewName());
        assertFalse(view.getModelMap().containsValue(comentario));


    }
}