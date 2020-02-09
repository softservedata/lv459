package com.softserve.edu.rest.resources;


import com.softserve.edu.rest.dto.RestUrlRepository;
import com.softserve.edu.rest.engine.RestQueries;
import com.softserve.edu.rest.entity.SimpleEntity;

public class CooldownTimeResource extends RestQueries<SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity, SimpleEntity> {

    public CooldownTimeResource() {
        super(RestUrlRepository.getCoolDownTime(), SimpleEntity.class, SimpleEntity.class,
                SimpleEntity.class, SimpleEntity.class, SimpleEntity.class);
    }
}
