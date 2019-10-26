package com.myproject.controller;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.entity.Senha;
import com.myproject.entity.TipoSenha;
import com.myproject.service.SenhaService;
import com.myproject.service.SequencialService;
import com.myproject.service.TipoSenhaService;

/**
 * @author Rafael Machado
 * @version 1.0
 */

@Controller
public class PasswordController {
    
    private static final Logger logger = Logger.getLogger(PasswordController.class);
    
    public PasswordController() {
        System.out.println("PasswordController()");
    }

    @Autowired
    private SenhaService senhaService;
    @Autowired
    private SequencialService sequencialService;
    @Autowired
    private TipoSenhaService tipoSenhaService;

    @RequestMapping(value = {"createPassword", ""})
    public ModelAndView createPassword(@RequestParam long id) {
        logger.info("Creating Password");
        if (id > 0) {
        	TipoSenha tipo = tipoSenhaService.getTipoSenha(id);
        	if (tipo != null) {
        		String nrSequencial = sequencialService.getSequencialNumber(id, tipo.getSiglaTipo());
        		Senha senha = new Senha(tipo, nrSequencial, new Date());
        		senhaService.createPassword(senha);
        	}
        }
        return new ModelAndView("redirect:getAllPasswords");
    }
    
    @RequestMapping(value = {"getAllPasswords", "/"})
    public ModelAndView getAllPasswords() {
        logger.info("Getting the all Passwords.");
        List<Senha> passwordList = senhaService.getAllPasswords();
        return new ModelAndView("passwordList", "passwordList", passwordList);
    }
    
    @RequestMapping("managersView")
    public ModelAndView managersView() {
        logger.info("Manager´s view.");
        return new ModelAndView("managerForm");
    }
    
    @RequestMapping("resetAllSequences")
    public ModelAndView resetAllSequences() {
    	logger.info("Reset all Sequences.");
    	senhaService.updateAllSequences();
    	return new ModelAndView("redirect:getAllPasswords");
    }
    
    @RequestMapping("getListOrdered")
    public ModelAndView getListOrdered() {
        logger.info("Getting the list Ordered.");
        List<Senha> passwordList = senhaService.getListOrdered();
        return new ModelAndView("passwordList", "passwordList", passwordList);
    }
    
    @RequestMapping("deleteAllPasswords")
    public ModelAndView deleteAllPasswords() {
    	logger.info("Deleting all Passwords.");
    	senhaService.deleteAllPasswords();
    	return new ModelAndView("redirect:getAllPasswords");
    }
    
}