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
 * @author HOME
 */
@Controller
@RequestMapping("comentario")
public class ComentarioController{

    private ComentarioDAO comentarioDAO;

    @Autowired
    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @RequestMapping(value = "/page1.htm", method = RequestMethod.GET)
    public ModelAndView page1(
            @ModelAttribute("comentario") Comentario comentario)
            throws Exception {

        comentarioDAO.adicionar(comentario);
        ModelMap model = new ModelMap();
        model.addAttribute("lista", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("page1", model);
    }
    
    @RequestMapping(value = "/page2.htm", method = RequestMethod.GET)
    public ModelAndView page2(
            @ModelAttribute("comentario") Comentario comentario)
            throws Exception {

        comentarioDAO.adicionar(comentario);
        ModelMap model = new ModelMap();
        model.addAttribute("lista", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("page2", model);
    }
    
    @RequestMapping(value = "/page3.htm", method = RequestMethod.GET)
    public ModelAndView page3(
            @ModelAttribute("comentario") Comentario comentario)
            throws Exception {

        comentarioDAO.adicionar(comentario);
        ModelMap model = new ModelMap();
        model.addAttribute("lista", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("page3", model);
    }
    
    @RequestMapping(value = "/page4.htm", method = RequestMethod.GET)
    public ModelAndView page4(
            @ModelAttribute("comentario") Comentario comentario)
            throws Exception {

        comentarioDAO.adicionar(comentario);
        ModelMap model = new ModelMap();
        model.addAttribute("lista", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("page4", model);
    }
}
