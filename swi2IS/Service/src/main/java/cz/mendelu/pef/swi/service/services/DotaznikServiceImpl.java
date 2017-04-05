/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.dao.dao.DotaznikDao;
import cz.mendelu.pef.swi.dao.domain.Dotaznik;
import cz.mendelu.pef.swi.dao.domain.Role;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 *
 * @author Martin
 */


public class DotaznikServiceImpl implements DotaznikService{
    
    private DotaznikDao dotaznikDao;
    
    @Override
    public void create(Dotaznik dotaznik) {
        dotaznikDao.save(dotaznik);
    }

    @Override
    public Dotaznik findById(int id) {
       return dotaznikDao.findById(id);
    }

    @Override
    public List<Dotaznik> findAll() {
        return dotaznikDao.findAll();
    }

    @Override
    public void delete(Dotaznik dotaznik) {
        dotaznikDao.delete(dotaznik);
    }

    @Override
    public Dotaznik findByTitle(String Title){
        return dotaznikDao.findByTitle(Title);
        
    }
    @Override
    public Role getRoleForDotaznik(Dotaznik dotaznik) {
        if (isAdminUser(dotaznik)) return Role.ROLE_ADMIN;
        return Role.ROLE_ENTERPRISE;
            
        
    }

    @Override
    public boolean isAdminUser(Dotaznik dotaznik) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
