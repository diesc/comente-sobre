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
 * @author disou_000 Classe controladora do sisteme de comentários da página
 * redes sociais
 */
@Controller
public class RedeSocialController {

    @Autowired
    private ComentarioDAO comentarioDAO;

    /**
     *
     * @param comentarioDAO
     */
    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    /**
     * Método ModelAndView para carregar e listar os comentarios no form da
     * página pagina-redes-sociais
     *
     * @param model
     * @return pagina-redes-sociais.htm
     */
    @RequestMapping(value = "/redes-sociais", method = RequestMethod.GET)
    public ModelAndView mostrarPagina(ModelMap model) {

        model.addAttribute("listar", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("pagina-redes-sociais", model);
    }

    /**
     * Método ModelAndView para adicionar ao banco o nome, email e o comentario
     * do usuário no método mostrarPagina
     *
     * @param comentario
     * @return return:redes-sociais.htm
     */
    @RequestMapping(value = "/adicionarRede", method = RequestMethod.POST)
    public ModelAndView adicionarComentario(
            @ModelAttribute("comentario") Comentario comentario) {

        comentarioDAO.adicionar(comentario);
        return new ModelAndView("redirect:redes-sociais.htm");
    }
}
