package com.myproject.dao;

import com.myproject.entity.SequencialSenha;

public interface SequencialSenhaDAO {
	
	String getSequencialNumber(long id, String sigla);
	
	SequencialSenha updateSequencial(SequencialSenha sequencial);

}
