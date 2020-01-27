package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.engine.RestQueries;
import com.softserve.edu.rest.entity.SimpleEntity;

public class LogoutResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public LogoutResource() {
    	super(RestUrlRepository.getLogout(),
				SimpleEntity.class, SimpleEntity.class,
				SimpleEntity.class, SimpleEntity.class, SimpleEntity.class);
    }

    @Override
    public SimpleEntity httpDeleteAsEntity(RestParameters pathVariables, RestParameters urlParameters,
			RestParameters bodyParameters) {
		return httpPostAsEntity(pathVariables, urlParameters, bodyParameters);
	}
}
