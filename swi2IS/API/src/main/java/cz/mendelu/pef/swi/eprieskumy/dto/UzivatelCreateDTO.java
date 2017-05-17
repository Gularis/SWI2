/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.eprieskumy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author veronika.almasiova
 */
public class UzivatelCreateDTO {
    @NotNull
    @Size(min = 4, max = 40)
    private String nameUzivatel;
    
    private String name;
    
    private String surname;

    private String ICO;
    
    private String titul;
    
    private String place;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public String getNameUzivatel() {
        return nameUzivatel;
    }

    public void setNameUzivatel(String nameUzivatel) {
        this.nameUzivatel = nameUzivatel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getICO() {
        return ICO;
    }

    public void setICO(String ICO) {
        this.ICO = ICO;
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}

