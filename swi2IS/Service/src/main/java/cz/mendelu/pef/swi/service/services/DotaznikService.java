/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
        
/**
 *
 * @author Martin
 */
public interface DotaznikService extends UserDetailsService{
    void create(Dotaznik dotaznik);
    
     Dotaznik findById(int id);
     
     Dotaznik findByTitle(String title);

    List<Dotaznik> findAll();

    void delete(Dotaznik dotaznik);

   // void update(Dotaznik dotaznik, String title,String description);
    
    
    Role getRoleForDotaznik(Dotaznik dotaznik);
    
    boolean isAdminUser(Dotaznik dotaznik);
    


}
