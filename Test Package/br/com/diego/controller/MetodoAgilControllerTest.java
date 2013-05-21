/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.controller;

import static junit.framework.Assert.assertFalse;

import br.com.diego.dao.ComentarioDAO;
import br.com.diego.model.Comentario;
import java.util.List;
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
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class MetodoAgilControllerTest {

    @Autowired
    private ComentarioDAO comentarioDAO;
    private Comentario comentario;

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    
}