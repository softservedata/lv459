package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrlKeys;
import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.engine.RestQueries;
import com.softserve.edu.rest.entity.SimpleEntity;

// Rename Logged in
public class LoginResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

	public LoginResource() {
		super(RestUrlRepository.getUserAuthorized(),
				SimpleEntity.class, SimpleEntity.class,
				SimpleEntity.class, SimpleEntity.class, SimpleEntity.class);
	}

	@Override
    public SimpleEntity httpDeleteAsEntity(RestParameters pathVariables, RestParameters urlParameters,
			RestParameters bodyParameters) {
		return httpPostAsEntity(pathVariables, urlParameters, bodyParameters,
				getRestUrl().clone().addPostUrl(getRestUrl().getUrl(RestUrlKeys.DELETE)));
	}
}
