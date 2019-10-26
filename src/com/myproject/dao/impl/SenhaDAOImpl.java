package com.myproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.dao.SenhaDAO;
import com.myproject.entity.Senha;
import com.myproject.util.HibernateUtil;

/**
 * @author Rafael Machado
 * @version 1.0
 */

@Repository
public class SenhaDAOImpl implements SenhaDAO {
    
    public SenhaDAOImpl() {
        System.out.println("SenhaDAOImpl()");
    }
    
    @Autowired
    private HibernateUtil hibernateUtil;
    
	@Override
	public long createPassword(Senha senha) {
		return (Long) hibernateUtil.create(senha);
	}
	
	@Override
	public List<Senha> getAllPasswords() {
		return hibernateUtil.fetchAll(Senha.class);
	}

	@Override
	public void deleteAllPasswords() {
		hibernateUtil.createQuery("Delete from Senha");
	}
	
	@Override
	public void updateAllSequences() {
		hibernateUtil.createQuery("Update SequencialSenha set numeroSequencial = 0");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Senha> getListOrdered() {
        String query = 
        		"SELECT s.* FROM Senha s "
        		+ "inner join Tipo_Senha ts on s.sq_tipo_senha = ts.sq_tipo_senha "
        		+ "ORDER BY ts.sq_tipo_senha desc, s.cd_senha asc";
        
        List<Object[]> passwordObjects = hibernateUtil.fetchAll(query);
        List<Senha> passwords = new ArrayList<Senha>();
        for(Object[] password: passwordObjects) {
            Senha senha = new Senha();
            int id = (Integer) password[0];
            String codigoSenha = (String) password[2];
            senha.setId(new Long(id));
            senha.setCodigoSenha(codigoSenha);
            passwords.add(senha);
        }
        System.out.println(passwords);
        return passwords;
	}
    
}
