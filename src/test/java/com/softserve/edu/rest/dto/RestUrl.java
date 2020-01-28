package com.softserve.edu.rest.dto;

import java.util.HashMap;
import java.util.Map;

public class RestUrl implements Cloneable {
	private Map<RestUrlKeys, String> urls;

	public RestUrl() {
		urls = new HashMap<>();
	}

	public Map<RestUrlKeys, String> getUrls() {
		return urls;
	}

	public RestUrl addUrl(RestUrlKeys key, String url) {
		urls.put(key, url);
		return this;
	}

	public String getUrl(RestUrlKeys key) {
		return urls.get(key);
	}

	public RestUrl addBaseUrl(String url) {
		urls.put(RestUrlKeys.BASE, url);
		return this;
	}

	public RestUrl addGetUrl(String url) {
		urls.put(RestUrlKeys.GET, url);
		return this;
	}

	public RestUrl addPostUrl(String url) {
		urls.put(RestUrlKeys.POST, url);
		return this;
	}

	public RestUrl addPutUrl(String url) {
		urls.put(RestUrlKeys.PUT, url);
		return this;
	}

	public RestUrl addDeleteUrl(String url) {
		urls.put(RestUrlKeys.DELETE, url);
		return this;
	}

	public RestUrl addPatchUrl(String url) {
		urls.put(RestUrlKeys.PATCH, url);
		return this;
	}

	public String readBaseUrl() {
		return urls.get(RestUrlKeys.BASE);
	}

	public String readGetUrl() {
		return readBaseUrl() + urls.get(RestUrlKeys.GET);
	}

	public String readPostUrl() {
		return readBaseUrl() + urls.get(RestUrlKeys.POST);
	}

	public String readPutUrl() {
		return readBaseUrl() + urls.get(RestUrlKeys.PUT);
	}

	public String readDeleteUrl() {
		return readBaseUrl() + urls.get(RestUrlKeys.DELETE);
	}

	public String readPatchUrl() {
		return readBaseUrl() + urls.get(RestUrlKeys.PATCH);
	}

	@Override
	public RestUrl clone() {
		RestUrl cloneRestUrl = new RestUrl();
		for (Map.Entry<RestUrlKeys, String> currentUrl : getUrls().entrySet()) {
			cloneRestUrl.addUrl(currentUrl.getKey(), currentUrl.getValue());
		}
		return cloneRestUrl;
	}

	@Override
	public String toString() {
		String result = "RestUrl [";
		for (Map.Entry<RestUrlKeys, String> currentUrl : getUrls().entrySet()) {
			result = result
					+ " Method = " + currentUrl.getKey().name()
					+ " Uri: " + currentUrl.getValue();
		}
		return result + "]";
	}
	
}
