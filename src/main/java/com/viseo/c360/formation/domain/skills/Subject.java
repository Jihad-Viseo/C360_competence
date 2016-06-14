package com.viseo.c360.formation.domain.skills;


import com.sun.istack.internal.NotNull;
import com.viseo.c360.formation.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Subject extends BaseEntity{

    @NotNull
    String name;

    @ManyToMany
    List<Subject> closeSubjects;

    public Subject(String name) {
        this.name = name;
        this.closeSubjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getCloseSubjects() {
        return Collections.unmodifiableList(closeSubjects);
    }

    public void addCloseSubject (Subject subject){
        closeSubjects.add(subject);
        subject.closeSubjects.add(this);
    }

    public void removeCloseSubject(Subject subject){
        closeSubjects.remove(subject);
        subject.closeSubjects.remove(this);
    }
}
