package com.re.srinivasa.homesite.backend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Company extends AbstractEntity {

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Contact> employees = new LinkedList<>();

    public Company() {

    }
}
