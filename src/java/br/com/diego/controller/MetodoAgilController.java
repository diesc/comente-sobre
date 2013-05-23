/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.controller;

import br.com.diego.dao.ComentarioDAO;
import br.com.diego.model.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego Classe controladora do sisteme de comentários da página metodos
 * ageis
 */
@Controller
public class MetodoAgilController {

    @Autowired
    private ComentarioDAO comentarioDAO;

    /**
     *
     * @param comentarioDAO controlar as entradas dos métodos: adicionar e
     * listar da classe ComentarioDAO
     */
    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    /**
     * Método ModelAndView para carregar e listar os comentarios no form da
     * página pagina-metodos-ageis
     *
     * @param model
     * @return pagina-metodos-ageis
     */
    @RequestMapping(value = "/metodos-ageis", method = RequestMethod.GET)
    public ModelAndView mostrarPagina(ModelMap model) {

        model.addAttribute("listar", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("pagina-metodos-ageis", model);
    }

    /**
     * Método ModelAndView para adicionar ao banco o nome, email e o comentario
     * do usuário no método mostrarPagina
     *
     * @param comentario
     * @return return:metodos-ageis.htm
     */
    @RequestMapping(value = "/adicionarMetodo", method = RequestMethod.POST)
    public ModelAndView adicionarComentario(
            @ModelAttribute("comentario") Comentario comentario) {

        comentarioDAO.adicionar(comentario);

        return new ModelAndView("redirect:metodos-ageis.htm");
    }
}
