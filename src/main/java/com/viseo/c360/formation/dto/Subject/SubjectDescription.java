package com.viseo.c360.formation.dto.Subject;

import com.sun.istack.internal.NotNull;
import com.viseo.c360.formation.domain.skills.Subject;
import com.viseo.c360.formation.dto.BaseDTO;

import java.util.ArrayList;
import java.util.List;

public class SubjectDescription extends BaseDTO {

    String name;

    List<SubjectDescription> closeSubjects;

    public SubjectDescription() {
        this.closeSubjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDescription> getCloseSubjects() {
        return closeSubjects;
    }
}
