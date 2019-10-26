package com.myproject.dao;

import java.util.List;

import com.myproject.entity.Senha;

public interface SenhaDAO {
	
	public long createPassword(Senha senha);
	
    public List<Senha> getAllPasswords();
    
    public void deleteAllPasswords();
    
    public void updateAllSequences();
    
    public List<Senha> getListOrdered();

}
