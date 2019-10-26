package com.myproject.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.dao.TipoSenhaDAO;
import com.myproject.entity.TipoSenha;
import com.myproject.util.HibernateUtil;

/**
 * @author Rafael Machado
 * @version 1.0
 */

@Repository
public class TipoSenhaDAOImpl implements TipoSenhaDAO {
	
    public TipoSenhaDAOImpl() {
        System.out.println("TipoSenhaDAOImpl()");
    }
    
    @Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public TipoSenha getTipoSenha(long id) {
		 return hibernateUtil.fetchById(id, TipoSenha.class);
	}

}
