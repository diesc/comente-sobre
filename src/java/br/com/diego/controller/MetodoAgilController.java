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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
//@RequestMapping("metodo-agil")
public class MetodoAgilController {

    @Autowired
    private ComentarioDAO comentarioDAO;

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @RequestMapping(value = "/metodo-agil", method = RequestMethod.GET)
    public ModelAndView mostrarPagina(ModelMap model) {

        model.addAttribute("listar", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());
        return new ModelAndView("pagina-metodos-ageis", model);
    }

    @RequestMapping(value = "/adicionarContato", method = RequestMethod.POST)
    public ModelAndView adicionarContato(
            @ModelAttribute("comentario") Comentario comentario,
            BindingResult result) {


        comentarioDAO.adicionar(comentario);
        /*System.out.println("Nome:" + comentario.getNmCliente()
         + ", Email:" + comentario.getNmClienteEmail()
         + ", Comentario: " + comentario.getNmClienteComentario());*/

        return new ModelAndView("redirect:metodo-agil.htm");
    }
}
