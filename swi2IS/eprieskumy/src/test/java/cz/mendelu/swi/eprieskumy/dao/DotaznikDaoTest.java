/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.swi.eprieskumy.dao;

import cz.mendelu.pef.swi.eprieskumy.dao.DotaznikDao;
import cz.mendelu.pef.swi.eprieskumy.domain.Dotaznik;
import cz.mendelu.pef.swi.eprieskumy.utils.DatabaseConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
/**
 *
 * @author michal.balko
 */
@ContextConfiguration(classes = DatabaseConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional

    
    
 
public class DotaznikDaoTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private DotaznikDao dotaznikDao;

    @Test
    public void testSave() {
        Dotaznik dotaznik = new Dotaznik("Mega dotaznik", "vyplnte mega",55);
        Dotaznik dotaznik2 = new Dotaznik("Ultra", "vyplnte ultra",100);

        dotaznikDao.save(dotaznik);
        dotaznikDao.save(dotaznik2);
        dotaznikDao.findByTitle("Mega dotaznik");
       System.out.println("Najdene doazniky"+dotaznikDao.findAll());

   

    }
}
