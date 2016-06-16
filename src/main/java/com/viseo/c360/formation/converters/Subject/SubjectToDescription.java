package com.viseo.c360.formation.converters.Subject;


import com.viseo.c360.formation.domain.skills.Subject;
import com.viseo.c360.formation.dto.Subject.SubjectDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectToDescription {

    public SubjectToDescription() {
    }

    public SubjectDescription convert(Subject source) {
        return convert(source,new HashMap<Subject, SubjectDescription>());
    }

    public List<SubjectDescription> convert(List<Subject> source) {
        List<SubjectDescription> result = new ArrayList<>();
        Map<Subject, SubjectDescription> cache = new HashMap<>();
        for(Subject subject : source){
            result.add(convert(subject,cache));
        }
        return result;
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