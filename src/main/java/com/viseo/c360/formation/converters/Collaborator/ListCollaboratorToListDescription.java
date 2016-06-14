package com.viseo.c360.formation.converters.Collaborator;

import com.viseo.c360.formation.domain.collaborator.Collaborator;
import com.viseo.c360.formation.dto.collaborator.CollaboratorDescription;

import java.util.ArrayList;
import java.util.List;


public class ListCollaboratorToListDescription {

    public ListCollaboratorToListDescription() {
    }

    public List<CollaboratorDescription> convert(List<Collaborator> sourceList) {
        List<CollaboratorDescription> listDto = new ArrayList<>();
        for (Collaborator collaborator : sourceList) {
            listDto.add(new CollaboratorToDescription().convert(collaborator));
        }
        return listDto;
    }

}
