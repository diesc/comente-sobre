/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.dao;

import br.com.diego.model.Comentario;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface ComentarioDAO {
    
    public void adicionar(Comentario comentario);
    public List<Comentario> listar();
    
}
