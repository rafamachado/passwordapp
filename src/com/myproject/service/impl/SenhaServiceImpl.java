package com.myproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.SenhaDAO;
import com.myproject.entity.Senha;
import com.myproject.service.SenhaService;

/**
 * @author Rafael Machado
 * @version 1.0
 */

@Service
@Transactional
public class SenhaServiceImpl implements SenhaService {
    
    public SenhaServiceImpl() {
        System.out.println("SenhaServiceImpl()");
    }
    
    @Autowired
    private SenhaDAO senhaDAO;

    @Override
    public long createPassword(Senha senha) {
        return senhaDAO.createPassword(senha);
    }
    
    @Override
    public List<Senha> getAllPasswords() {
        return senhaDAO.getAllPasswords();
    }

	@Override
	public void deleteAllPasswords() {
		senhaDAO.deleteAllPasswords();
		
	}

	@Override
	public void updateAllSequences() {
		senhaDAO.updateAllSequences();
	}

	@Override
	public List<Senha> getListOrdered() {
		return senhaDAO.getListOrdered();
	}
    
}
