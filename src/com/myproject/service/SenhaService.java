package com.myproject.service;

import java.util.List;

import com.myproject.entity.Senha;

/**
 * @author Rafael Machado
 * @version 1.0
 */
public interface SenhaService {
	
    public long createPassword(Senha senha);
    
    public List<Senha> getAllPasswords();
    
    public void deleteAllPasswords();
    
    public void updateAllSequences();
    
    public List<Senha> getListOrdered();
    
}
