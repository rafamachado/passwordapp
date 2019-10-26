package com.myproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.TipoSenhaDAO;
import com.myproject.entity.TipoSenha;
import com.myproject.service.TipoSenhaService;

/**
 * @author Rafael Machado
 * @version 1.0
 */

@Service
@Transactional
public class TipoSenhaServiceImpl implements TipoSenhaService {
	
    public TipoSenhaServiceImpl() {
        System.out.println("TipoSenhaServiceImpl()");
    }
    
    @Autowired
    private TipoSenhaDAO tipoSenhaDAO;

	@Override
	public TipoSenha getTipoSenha(long id) {
		return tipoSenhaDAO.getTipoSenha(id);
	}

}
