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
 * @author Diego Classe que testa a conexão com banco de dados, armazenamento
 * dos arquivos e suas listagens
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"file:web/WEB-INF/applicationContextTest.xml"})
public class ComentarioDAOImplTest {

    @Autowired
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;

    /**
     *
     * @param comentarioDAO controla as entradas dos métodos: adicionar e listar
     * da classe ComentarioDAO
     */
    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    /**
     * Configurando as instâncias de entrada de dados na classe Comentario Nome:
     * Teste, Email: teste@teste.com.br Comentario: Testando!
     */
    @Before
    public void setUp() {
        comentario = new Comentario("Teste", "teste@teste.com.br", "Testado!");
    }

    /**
     * Testa o método adicionar. Inserido as entradas definidas no método: newm
     * Comentario() da classe Comentario
     */
    @Test
    public void testAdicionarComentario() {
        try {

            comentarioDAO.adicionar(comentario);

        } catch (Exception e) {
            Assert.fail("Something was going wrong!" + e);
        }
    }

    /**
     * Testa o método listar
     */
    @Test
    public void testListarComentario() {
        assertFalse(comentarioDAO.listar().isEmpty());
    }
}
