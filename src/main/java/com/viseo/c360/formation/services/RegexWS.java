package com.viseo.c360.formation.services;

import java.util.HashMap;
import java.util.Map;

import com.viseo.c360.formation.dto.collaborator.CollaboratorDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegexWS {
	
	@RequestMapping(value="${endpoint.regexCollaborators}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getRegexCollaborators(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("PERSONNAL_ID_NUMBER", "^"+ CollaboratorDescription.Regex.PERSONNAL_ID_NUMBER +"+$");
		map.put("LAST_NAME","^"+ CollaboratorDescription.Regex.LAST_NAME +"+$");
		map.put("FIRST_NAME","^"+ CollaboratorDescription.Regex.FIRST_NAME +"+$");
		return map;
	}
}
