package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrlKeys;
import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.engine.RestQueries;
import com.softserve.edu.rest.entity.SimpleEntity;

public class ApplicationResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

	public ApplicationResource() {
		super(RestUrlRepository.getApplication(),
				SimpleEntity.class, SimpleEntity.class,
				SimpleEntity.class, SimpleEntity.class, SimpleEntity.class);
	}

	@Override
    public SimpleEntity httpPutAsEntity(RestParameters pathVariables, RestParameters urlParameters,
			RestParameters bodyParameters) {
		return httpGetAsEntity(pathVariables, urlParameters,
				getRestUrl().clone().addPutUrlAsFirst(getRestUrl().getUrl(RestUrlKeys.GET)));
	}

}
