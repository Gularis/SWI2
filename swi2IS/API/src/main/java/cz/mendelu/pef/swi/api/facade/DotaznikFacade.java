/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.api.facade;

import cz.mendelu.pef.swi.api.dto.DotaznikCreateDTO;
import cz.mendelu.pef.swi.api.dto.DotaznikDTO;
import java.util.List;

/**
 *
 * @author veronika.almasiova
 */
public interface DotaznikFacade {
    /**
     * Create new Dotaznik
     *
     * @param t DotaznikCreateDTO - information about new Dotaznik
     * @return ID of new Dotaznik.
     */
    int createDotaznik(DotaznikCreateDTO t);

    /**
     * Delete existing Dotaznik
     *
     * @param dotaznikId ID of Dotaznik
     */
    void deleteDotaznik(int dotaznikId);

    /**
     * Gets all existing Dotaznik
     *
     * @return List of DotaznikDTOs
     */
    List<DotaznikDTO> getAllDotaznik();

    /**
     * Gets Bagde Able Dotaznik
     *
     * @return List of DotaznikDTOs
     */
    public DotaznikDTO getDotaznikWithId(int id);
}

