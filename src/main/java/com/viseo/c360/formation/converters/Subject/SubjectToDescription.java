package com.viseo.c360.formation.converters.Subject;


import com.viseo.c360.formation.domain.skills.Subject;
import com.viseo.c360.formation.dto.Subject.SubjectDescription;

import java.util.HashMap;
import java.util.Map;

public class SubjectToDescription {

    public SubjectToDescription() {
    }

    public SubjectDescription convert(Subject source) {
        return convert(source,new HashMap<Subject, SubjectDescription>());
    }

    SubjectDescription convert(Subject source, Map<Subject, SubjectDescription> alreadyConverted) {
        if (alreadyConverted.containsKey(source)) {
            return alreadyConverted.get(source);
        } else {
            SubjectDescription dto = new SubjectDescription();
            dto.setId(source.getId());
            dto.setName(source.getName());
            alreadyConverted.put(source, dto);
            for (Subject closeSubject : source.getCloseSubjects()){
                SubjectDescription closeSubjectDescription = convert(closeSubject);
                dto.getCloseSubjects().add(closeSubjectDescription);
            }
            return dto;
        }
    }
}