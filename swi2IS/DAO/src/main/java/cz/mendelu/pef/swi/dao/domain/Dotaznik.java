/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.pef.swi.dao.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 *
 * @author michal.balko
 */

@Entity
public class Dotaznik {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    private Date dt_from;
    
    private Date dt_until;

    private Integer respondents;
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDt_from() {
        return dt_from;
    }
    public Date getDt_until() {
        return dt_until;
    }

    public Integer getRespondents() {
        return respondents;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDt_from(Date dt_from) {
        this.dt_from = dt_from;
    }

    public void setDt_until(Date dt_until) {
        this.dt_until = dt_until;
    }

    public void setRespondents(Integer respondents) {
        this.respondents = respondents;
    }

    public Dotaznik() {
    }
    
    public Dotaznik(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Dotaznik(int id, String title, String description, Date dt_from, Date dt_until, Integer respondents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dt_from = dt_from;
        this.dt_until = dt_until;
        this.respondents = respondents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dotaznik other = (Dotaznik) obj;
        return Objects.equals(this.description, other.description);
    }
    
}
