/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.dao;

import br.com.diego.model.Comentario;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diego Classe que implementa os métodos contidos na classe interface
 * ComentarioDAO
 */
@Repository("comentarioDAO")
public class ComentarioDAOImpl implements ComentarioDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * Controlar as entradas no banco dados Automaticamente abre, fecha, commit
     * e/ou rollback depois que o código foi executado
     *
     * @param sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    /**
     * Método que guarda as informações no banco de dados
     *
     * @param comentario
     */
    @Override
    public void adicionar(Comentario comentario) {
        hibernateTemplate.saveOrUpdate(comentario);
    }

    /**
     * Método que lista todo conteudo armazenado no banco
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Comentario> listar() {
        return hibernateTemplate.find("from Comentario");
    }
}
