package com.myproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.SequencialSenhaDAO;
import com.myproject.service.SequencialService;

@Service
@Transactional
public class SequencialServiceImpl implements SequencialService {
	
    public SequencialServiceImpl() {
        System.out.println("SequencialServiceImpl()");
    }
    
    @Autowired
    private SequencialSenhaDAO sequencialSenhaDAO;
	
	@Override
	public String getSequencialNumber(long id, String sigla) {
		return sequencialSenhaDAO.getSequencialNumber(id, sigla);
	}
	
}
