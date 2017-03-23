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
        Dotaznik dotaznik = new Dotaznik(1,"Cas straveny na projekte", "pocet v hodinach");

        dotaznikDao.save(dotaznik);

        Dotaznik result = dotaznikDao.findById(dotaznik.getId());
        assertEquals(dotaznik, result);

        dotaznik.setTitle("Cas straveny hranim hier");
        dotaznikDao.save(dotaznik);

        Dotaznik resultUpdate = dotaznikDao.findById(dotaznik.getId());
        assertEquals("Cas straveny hranim hier", resultUpdate.getTitle());

    }
}
