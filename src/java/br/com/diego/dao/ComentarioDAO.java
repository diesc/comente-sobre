/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.dao;

import br.com.diego.model.Comentario;
import java.util.List;

/**
 *
 * @author HOME Tipo de classe abstrata onde é implementada pela classe
 * ComentarioDAOImpl contendo apenas as assinaturas dos métodos: adicionar e
 * listar
 */
public interface ComentarioDAO {

    /**
     * Método que armazena os dados no banco de dados será implementado pela
     * classe ComentarioDAOImpl
     *
     * @param comentario
     */
    public void adicionar(Comentario comentario);

    /**
     * Método que lista os dados contidos no banco de dados será implementado
     * pela classe ComentarioDAOImpl
     *
     * @return
     */
    public List<Comentario> listar();
}
