package com.softserve.edu.rest.resources;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrlKeys;
import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.engine.RestQueries;
import com.softserve.edu.rest.entity.SimpleEntity;

public class ItemIndexUserNameResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public ItemIndexUserNameResource() {
        super(RestUrlRepository.getUserItem(),
              SimpleEntity.class,
              SimpleEntity.class,
              SimpleEntity.class,
              SimpleEntity.class,
              SimpleEntity.class);
    }
}
