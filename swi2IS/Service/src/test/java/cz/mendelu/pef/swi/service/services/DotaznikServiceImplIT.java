/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.service.services;

import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.domain.Role;
import cz.mendelu.pef.swi.service.service.config.ServiceConfiguration;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import static org.testng.Assert.assertEquals;


/**
 *
 * @author Martin
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class DotaznikServiceImplIT extends AbstractTestNGSpringContextTests{
    
    @Mock
    private DotaznikDao dotaznikDao;
    
    
    @Autowired
    @InjectMocks
    private DotaznikService dotaznikService;
    
    
    private Dotaznik dotaznik ;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        dotaznik = new Dotaznik("mega dotaznik", "maega vyplnit", 100);

        dotaznikService.create(dotaznik);
    }
    
    @Test
    public void testFindAll() {
        when(dotaznikDao.findAll()).thenReturn(new ArrayList<>(createDotaznikyGroup().values()));
        assertEquals(dotaznikService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(dotaznikDao.findById(1)).thenReturn(createDotaznikyGroup().get("dotaznik2"));
        assertEquals(dotaznikService.findById(1), new Dotaznik("dotaznik2", "vyplnte 2", 50));
    }
    
    private Map<String, Dotaznik> createDotaznikyGroup() {
        System.out.println("ok");
        Map<String, Dotaznik> group = new HashMap<>();
        group.put("dotaznik1", new Dotaznik("dotaznik1", "vyplnte 1", 25));
        group.put("dotaznik2", new Dotaznik("dotaznik2", "vyplnte 2", 50));
        return group;
    }
    
    
}