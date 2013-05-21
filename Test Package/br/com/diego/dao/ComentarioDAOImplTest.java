/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.dao;

import static junit.framework.Assert.assertFalse;

import br.com.diego.model.Comentario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author disou_000
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContextTest.xml"})
public class ComentarioDAOImplTest {
    
    @Autowired
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @Before
    public void setUp() {
        comentario = new Comentario();
    }

    @Test
    public void testAdicionarComentario() {
        try {
            comentario.setNmCliente("Diego");
            comentario.setNmClienteEmail("test@test.com");
            comentario.setNmClienteComentario("Testando e comentando");
            comentarioDAO.adicionar(comentario);

        } catch (Exception e) {
            Assert.fail("Something was going wrong!");
        }
    }
    
    @Test
    public void testListarComentario(){
        assertFalse(comentarioDAO.listar().isEmpty());
    }
}
