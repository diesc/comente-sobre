/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.controller;

import br.com.diego.dao.ComentarioDAO;
import br.com.diego.model.Comentario;
import br.com.diego.model.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Diego
 */
@Controller
@RequestMapping("metodo-agil")
public class MetodoAgilController {

    private ComentarioDAO comentarioDAO;

    @Autowired
    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    @RequestMapping(value = "/pagina-metodos-ageis.htm",
            method = RequestMethod.GET)
    public ModelAndView page1() throws Exception {

        ModelMap model = new ModelMap();
        model.addAttribute("lista", comentarioDAO.listar());
        model.addAttribute("comentario", new Comentario());

        return new ModelAndView("pagina-metodos-ageis", model);
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView add(@ModelAttribute("comentario") Comentario comentario, BindingResult result)
            throws Exception {

        JsonResponse res = new JsonResponse();
        ValidationUtils.rejectIfEmpty(result, "nmCliente", "Nome can not be empty.");
        ValidationUtils.rejectIfEmpty(result, "nmClienteEmail", "Email not be empty");
        ValidationUtils.rejectIfEmpty(result, "nmClienteComentario", "Comentario not be empty");
        if (!result.hasErrors()) {
            comentarioDAO.adicionar(comentario);
            res.setStatus("SUCCESS");
            res.setResult(comentarioDAO);
        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }

        return new ModelAndView("redirect:/metodo-agil/pagina-metodos-ageis.htm");
    }
}
