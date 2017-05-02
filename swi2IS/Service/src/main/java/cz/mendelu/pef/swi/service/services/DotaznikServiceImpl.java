/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Martin
 */

@Service
public class DotaznikServiceImpl implements DotaznikService{
    
    @Autowired
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Dotaznik dotaznik = dotaznikDao.findByTitle(s);

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(getRoleForDotaznik(dotaznik).toString()));

        return buildUserForAuthentication(dotaznik, auths);
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


    
   
    private UserDetails buildUserForAuthentication(Dotaznik dotaznik, List<GrantedAuthority> auths) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
