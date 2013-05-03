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

@Repository("comentarioDAO")
public class ComentarioDAOImpl implements ComentarioDAO {
    
    private HibernateTemplate hibernateTemplate;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    @Override
    public void adicionar(Comentario comentario) {
        hibernateTemplate.saveOrUpdate(comentario);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Comentario> listar() {
        return hibernateTemplate.find("from Comentario");
    }
    
}
