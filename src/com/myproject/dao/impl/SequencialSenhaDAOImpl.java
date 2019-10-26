package com.myproject.dao.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.dao.SequencialSenhaDAO;
import com.myproject.entity.SequencialSenha;
import com.myproject.util.HibernateUtil;

@Repository
public class SequencialSenhaDAOImpl implements SequencialSenhaDAO {
	
	private SequencialSenha seq;
	private Integer nrSequencial;
	
    public SequencialSenhaDAOImpl() {
        System.out.println("SequencialSenhaDAOImpl()");
    }
    
    @Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public String getSequencialNumber(long id, String sigla) {
		Date now = new Date();
		nextSequencial(id, now);
		String sequencialStr = sigla + StringUtils.leftPad(nrSequencial.toString(), 4, "0");
		return sequencialStr;
	}
	
	private synchronized void nextSequencial(long id, Date now) {
		seq = hibernateUtil.fetchById(id, SequencialSenha.class);
		nrSequencial = seq.getNumeroSequencial();
		nrSequencial++;
		seq.setNumeroSequencial(nrSequencial);
		seq.setDataUltimoSequencial(now);
		updateSequencial(seq);
	}

	@Override
	public SequencialSenha updateSequencial(SequencialSenha sequencial) {
		return hibernateUtil.update(sequencial);
	}

}
