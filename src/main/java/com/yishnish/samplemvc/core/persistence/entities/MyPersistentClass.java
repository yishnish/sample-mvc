package com.yishnish.samplemvc.core.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyPersistentClass {

    @Id
    int id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
