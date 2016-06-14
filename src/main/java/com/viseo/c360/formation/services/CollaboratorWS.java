package com.viseo.c360.formation.services;

import java.util.List;

import javax.inject.Inject;

import com.viseo.c360.formation.converters.Collaborator.DescriptionToCollaborator;
import com.viseo.c360.formation.converters.Collaborator.ListCollaboratorToListDescription;
import com.viseo.c360.formation.dto.collaborator.CollaboratorDescription;
import org.springframework.core.convert.ConversionException;
import org.springframework.web.bind.annotation.*;
import com.viseo.c360.formation.dao.CollaboratorDAO;


@RestController
public class CollaboratorWS {

    @Inject
    CollaboratorDAO collaboratorDAO;

    @RequestMapping(value = "${endpoint.collaborators}", method = RequestMethod.POST)
    @ResponseBody
    public boolean addCollaborator(@RequestBody CollaboratorDescription myCollaboratorDescription) {
        if (!collaboratorDAO.isPersonnalIdNumberPersisted(myCollaboratorDescription.getPersonnalIdNumber())) {
            try {
                collaboratorDAO.addCollaborator(new DescriptionToCollaborator().convert(myCollaboratorDescription));
                return true;
            } catch (ConversionException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @RequestMapping(value = "${endpoint.collaborators}", method = RequestMethod.GET)
    @ResponseBody
    public List<CollaboratorDescription> getAllCollaborators() {
        try {
            return new ListCollaboratorToListDescription().convert(collaboratorDAO.getAllCollaborators());
        } catch (ConversionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}