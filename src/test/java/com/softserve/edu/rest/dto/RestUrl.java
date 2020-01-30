package com.softserve.edu.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestUrl implements Cloneable {
	private Map<RestUrlKeys, List<String>> urls;

	public RestUrl() {
		initUrlKeys();
	}
	
	private void initUrlKeys() {
		urls = new HashMap<>();
		for (RestUrlKeys currentUrlKey : RestUrlKeys.values()) {
			urls.put(currentUrlKey, new ArrayList<String>());
		}
	}

	public Map<RestUrlKeys, List<String>> getUrls() {
		return urls;
	}

	public RestUrl addUrl(RestUrlKeys key, String url) {
		//urls.put(key, url);
		urls.get(key).add(url);
		return this;
	}

	public RestUrl addUrlAsFirst(RestUrlKeys key, String url) {
		urls.get(key).add(0, url);
		return this;
	}

	public RestUrl addUrlByInedex(RestUrlKeys key, String url, int index) {
		urls.get(key).add(index, url);
		return this;
	}

	public String getUrl(RestUrlKeys key) {
		//return urls.get(key).get(0);
		return getUrl(key, 0);
	}

	public String getUrl(RestUrlKeys key, int index) {
		return urls.get(key).get(index);
	}

	// add base
	
	public RestUrl addBaseUrl(String url) {
		//urls.put(RestUrlKeys.BASE, url);
		urls.get(RestUrlKeys.BASE).add(url);
		return this;
	}

	public RestUrl addBaseUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.BASE).add(index, url);
		return this;
	}

	public RestUrl addBaseUrlAsFirst(String url) {
		return addBaseUrlByIndex(url, 0);
	}

	// add get
	
	public RestUrl addGetUrl(String url) {
		//urls.put(RestUrlKeys.GET, url);
		urls.get(RestUrlKeys.GET).add(url);
		return this;
	}

	public RestUrl addGetUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.GET).add(index, url);
		return this;
	}

	public RestUrl addGetUrlAsFirst(String url) {
		return addGetUrlByIndex(url, 0);
	}

	// add post
	
	public RestUrl addPostUrl(String url) {
		//urls.put(RestUrlKeys.POST, url);
		urls.get(RestUrlKeys.POST).add(url);
		return this;
	}
	
	public RestUrl addPostUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.POST).add(index, url);
		return this;
	}

	public RestUrl addPostUrlAsFirst(String url) {
		return addPostUrlByIndex(url, 0);
	}

	// add put
	
	public RestUrl addPutUrl(String url) {
		//urls.put(RestUrlKeys.PUT, url);
		urls.get(RestUrlKeys.PUT).add(url);
		return this;
	}

	public RestUrl addPutUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.PUT).add(index, url);
		return this;
	}
	
	public RestUrl addPutUrlAsFirst(String url) {
		return addPutUrlByIndex(url, 0);
	}
	
	// add delete
	
	public RestUrl addDeleteUrl(String url) {
		//urls.put(RestUrlKeys.DELETE, url);
		urls.get(RestUrlKeys.DELETE).add(url);
		return this;
	}
	
	public RestUrl addDeleteUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.DELETE).add(index, url);
		return this;
	}
	
	public RestUrl addDeleteUrlAsFirst(String url) {
		return addDeleteUrlByIndex(url, 0);
	}

	// add patch
	
	public RestUrl addPatchUrl(String url) {
		//urls.put(RestUrlKeys.PATCH, url);
		urls.get(RestUrlKeys.PATCH).add(url);
		return this;
	}
	
	public RestUrl addPatchUrlByIndex(String url, int index) {
		urls.get(RestUrlKeys.PATCH).add(index, url);
		return this;
	}
	
	public RestUrl addPatchUrlAsFirst(String url) {
		return addPatchUrlByIndex(url, 0);
	}

	// read base
	
	public String readBaseUrl() {
		//return urls.get(RestUrlKeys.BASE);
		return readBaseUrlByIndex(0);
	}
	
	public String readBaseUrlByIndex(int index) {
		return urls.get(RestUrlKeys.BASE).get(index);
	}

	// read get
	
	public String readGetUrl() {
		//return readBaseUrl() + urls.get(RestUrlKeys.GET);
		return readGetUrlByIndex(0, 0);
	}

	public String readGetUrlByIndex(int indexBase, int indexGet) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestUrlKeys.GET).get(indexGet);
	}

	// read post
	
	public String readPostUrl() {
		//return readBaseUrl() + urls.get(RestUrlKeys.POST);
		return readPostUrlByIndex(0, 0);
	}

	public String readPostUrlByIndex(int indexBase, int indexPost) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestUrlKeys.POST).get(indexPost);
	}
	
	// read put
	
	public String readPutUrl() {
		//return readBaseUrl() + urls.get(RestUrlKeys.PUT);
		return readPutUrlByIndex(0, 0);
	}

	public String readPutUrlByIndex(int indexBase, int indexPut) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestUrlKeys.PUT).get(indexPut);
	}
	
	// read delete
	
	public String readDeleteUrl() {
		//return readBaseUrl() + urls.get(RestUrlKeys.DELETE);
		return readDeleteUrlByIndex(0, 0); 
	}
	
	public String readDeleteUrlByIndex(int indexBase, int indexDelete) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestUrlKeys.DELETE).get(indexDelete);
	}

	// read patch
	
	public String readPatchUrl() {
		//return readBaseUrl() + urls.get(RestUrlKeys.PATCH);
		return readPatchUrlByIndex(0, 0);
	}
	
	public String readPatchUrlByIndex(int indexBase, int indexPatch) {
		return readBaseUrlByIndex(indexBase) + urls.get(RestUrlKeys.PATCH).get(indexPatch);
	}

	@Override
	public RestUrl clone() {
		RestUrl cloneRestUrl = new RestUrl();
		for (Map.Entry<RestUrlKeys, List<String>> currentList : getUrls().entrySet()) {
			List<String> cloneCurrentList = cloneRestUrl.getUrls().get(currentList.getKey());
			for (String currentUrl : currentList.getValue()) {
				cloneCurrentList.add(currentUrl);
			}
		}
		//System.out.println("cloneRestUrl: " + cloneRestUrl);
		return cloneRestUrl;
	}

	@Override
	public String toString() {
		String result = "RestUrl [";
		for (Map.Entry<RestUrlKeys, List<String>> currentList : getUrls().entrySet()) {
			result = result
					+ "\n Method: " + currentList.getKey().name()
					+ " Uri: " + currentList.getValue();
		}
		return result + "]";
	}
	
}
