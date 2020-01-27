package com.softserve.edu.rest.dto;

import java.util.HashMap;
import java.util.Map;

public class RestParameters {
	private Map<String, String> parameters;

    public RestParameters() {
        parameters = new HashMap<>();
    }

    public RestParameters addParameter(String key, String value) {
        parameters.put(key, value);
        return this;
    }

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public Map<String, String> getAllParameters() {
        return parameters;
    }
}
