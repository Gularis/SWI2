/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.facade;

import cz.mendelu.pef.swi.api.dto.DotaznikCreateDTO;
import cz.mendelu.pef.swi.api.dto.DotaznikDTO;
import cz.mendelu.pef.swi.api.facade.DotaznikFacade;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.service.services.BeanMappingService;
import cz.mendelu.pef.swi.service.services.DotaznikService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author Martin
 */
public class DotaznikFacadeImpl implements DotaznikFacade{
    
    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private DotaznikService dotaznikService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int createDotaznik(DotaznikCreateDTO t) {
        Dotaznik newDotaznik= new Dotaznik(t.getTitle(),t.getDescription(),t.getRespondents());
        dotaznikService.create(newDotaznik);
        return newDotaznik.getId();
    }

    @Override
    public List<DotaznikDTO> getAllEnterprises() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DotaznikDTO getDotaznikWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
