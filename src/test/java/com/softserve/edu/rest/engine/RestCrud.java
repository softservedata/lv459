package com.softserve.edu.rest.engine;

import java.io.IOException;
import java.util.regex.Pattern;

import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.dto.RestUrl;
import com.softserve.edu.rest.dto.RestUrlKeys;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class RestCrud {
	private final String NOT_SUPPORT_MESSAGE = "Method %s not Support for %s Resource";
    //
    private final String URL_PARAMETERS_SEPARATOR = "?";
    private final String NEXT_PARAMETERS_SEPARATOR = "&";
    private final String KEY_VALUE_SEPARATOR = "=";
    //
    private RestUrl restUrl;
    private OkHttpClient client;

    public RestCrud(RestUrl restUrl)
    {
        this.restUrl = restUrl;
        client = new OkHttpClient();
    }

	protected RestUrl getRestUrl() {
		return restUrl;
	}
    
    // protected - - - - - - - - - - - - - - - - - - - -

    protected void throwException(String message)
    {
        // TODO Develop Custom Exception
        String resourceName = this.getClass().getName();
        resourceName = resourceName.substring(resourceName.lastIndexOf(".") + 1);
        System.out.println("resourceName = " + resourceName);
        throw new RuntimeException(String.format(NOT_SUPPORT_MESSAGE, message, resourceName));
    }

    protected void checkImplementation(RestUrlKeys restUrlKeys)
    {
        // if (restUrl.GetUrl(restUrlKeys).Length == 0)
    	String methodUri = getRestUrl().getUrl(restUrlKeys);
        if ((methodUri == null) || (methodUri.isEmpty()))
        {
            throwException(restUrlKeys.name());
        }
    }

    // Parameters - - - - - - - - - - - - - - - - - - - -
 
	private String prepareUrlParameters(String urlTemplate, RestParameters urlParameters)
    {
        if (urlParameters != null)
        {
            boolean isFirstParameter = true;
            for (String currentKey : urlParameters.getAllParameters().keySet()) {
                if (isFirstParameter)
                {
                    urlTemplate = urlTemplate + URL_PARAMETERS_SEPARATOR;
                    isFirstParameter = false;
                }
                else
                {
                    urlTemplate = urlTemplate + NEXT_PARAMETERS_SEPARATOR;
                }
                urlTemplate = urlTemplate + currentKey + KEY_VALUE_SEPARATOR + urlParameters.getParameter(currentKey);
            }
        }
        return urlTemplate;
    }

    private String preparePathVariables(String urlTemplate, RestParameters pathVariables) {
    	String url = urlTemplate;
        if (pathVariables != null) {
        	String searchVariable;
            for (String currentKey : pathVariables.getAllParameters().keySet()) {
            	// TODO Create Const
                searchVariable = "{" + currentKey + "}";
                if (url.contains(searchVariable)) {
                	// TODO Move to RegexUtils
                    url = url.replaceFirst(Pattern.quote(searchVariable), pathVariables.getParameter(currentKey));
                }
            }
        }
        return url;
    }

	private RequestBody prepareRequestBody(RestParameters bodyParameters) {
		FormBody.Builder formBodyBuilder = new FormBody.Builder();
		if (bodyParameters != null) {
			for (String currentKey : bodyParameters.getAllParameters().keySet()) {
				formBodyBuilder.add(currentKey, bodyParameters.getParameter(currentKey));
			}
		}
		return formBodyBuilder.build();
    }

    // Request - - - - - - - - - - - - - - - - - - - -

    private Request.Builder prepareRequestBuilder(String requestUrl, RestParameters pathVariables,
            RestParameters urlParameters) {
        if ((requestUrl == null) || (requestUrl.isEmpty())) {
            // TODO Develop Custom Exception
            //log.error("prepareRequestBuilder() Error ");
            throw new RuntimeException("prepareRequestBuilder() Error");

        }
        String url = preparePathVariables(requestUrl, pathVariables);
        url = prepareUrlParameters(url, urlParameters);
        return new Request.Builder().url(url);
    }
    
    private Response executeRequest(Request request) {
        Response result = null;
        try {
            result = client.newCall(request).execute();
        } catch (IOException e) {
            // TODO Develop Custom Exception
            //log.error("Request Error ");
            throw new RuntimeException("Request Error " + e.toString());
        }
        return result;
    }
    
    private String responseBodyAsText(Response response) {
        String responseText = null;
        try {
            responseText = response.body().string();
        } catch (IOException e) {
            // TODO Develop Custom Exception + Log
            // e.printStackTrace();
            //log.error("Error to get text from ResponseBody.");
            throw new RuntimeException("Error to get text from ResponseBody." + e.toString());
        }
        return responseText;
    }
    
    // Http Get - - - - - - - - - - - - - - - - - - - -

    protected Response httpGetAsResponse(RestParameters pathVariables, RestParameters urlParameters, RestUrl restUrl) {
    	checkImplementation(RestUrlKeys.GET);
        return executeRequest(prepareRequestBuilder(restUrl.readGetUrl(), pathVariables, urlParameters).get().build());
    }

    protected Response httpGetAsResponse(RestParameters pathVariables, RestParameters urlParameters) {
    	checkImplementation(RestUrlKeys.GET);
        return executeRequest(prepareRequestBuilder(getRestUrl().readGetUrl(), pathVariables, urlParameters).get().build());
    }

    protected String httpGetAsText(RestParameters pathVariables, RestParameters urlParameters, RestUrl restUrl) {
    	return responseBodyAsText(httpGetAsResponse(pathVariables, urlParameters, restUrl));
    }

    protected String httpGetAsText(RestParameters pathVariables, RestParameters urlParameters) {
    	return responseBodyAsText(httpGetAsResponse(pathVariables, urlParameters));
    }

    // Http Post - - - - - - - - - - - - - - - - - - - -

    protected Response httpPostAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
    	checkImplementation(RestUrlKeys.POST);
        return executeRequest(prepareRequestBuilder(restUrl.readPostUrl(), pathVariables, urlParameters)
                .post(prepareRequestBody(bodyParameters)).build());
    }

    protected Response httpPostAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
    	checkImplementation(RestUrlKeys.POST);
        return executeRequest(prepareRequestBuilder(getRestUrl().readPostUrl(), pathVariables, urlParameters)
                .post(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpPostAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
        return responseBodyAsText(httpPostAsResponse(pathVariables, urlParameters, bodyParameters, restUrl));
    }

    protected String httpPostAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpPostAsResponse(pathVariables, urlParameters, bodyParameters));
    }

    // Http Put - - - - - - - - - - - - - - - - - - - -

    protected Response httpPutAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
    	checkImplementation(RestUrlKeys.PUT);
        return executeRequest(prepareRequestBuilder(restUrl.readPutUrl(), pathVariables, urlParameters)
                .put(prepareRequestBody(bodyParameters)).build());
    }

    protected Response httpPutAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
    	checkImplementation(RestUrlKeys.PUT);
        return executeRequest(prepareRequestBuilder(getRestUrl().readPutUrl(), pathVariables, urlParameters)
                .put(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpPutAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
        return responseBodyAsText(httpPutAsResponse(pathVariables, urlParameters, bodyParameters, restUrl));
    }

    protected String httpPutAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpPutAsResponse(pathVariables, urlParameters, bodyParameters));
    }

    // Http Delete - - - - - - - - - - - - - - - - - - - -

    protected Response httpDeleteAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
    	checkImplementation(RestUrlKeys.DELETE);
        return executeRequest(prepareRequestBuilder(restUrl.readDeleteUrl(), pathVariables, urlParameters)
                .delete(prepareRequestBody(bodyParameters)).build());
    }

    protected Response httpDeleteAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
    	checkImplementation(RestUrlKeys.DELETE);
        return executeRequest(prepareRequestBuilder(getRestUrl().readDeleteUrl(), pathVariables, urlParameters)
                .delete(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpDeleteAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
        return responseBodyAsText(httpDeleteAsResponse(pathVariables, urlParameters, bodyParameters, restUrl));
    }

    protected String httpDeleteAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpDeleteAsResponse(pathVariables, urlParameters, bodyParameters));
    }

    // Http Patch - - - - - - - - - - - - - - - - - - - -

    protected Response httpPatchAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
    	checkImplementation(RestUrlKeys.PATCH);
        return executeRequest(prepareRequestBuilder(restUrl.readPatchUrl(), pathVariables, urlParameters)
                .patch(prepareRequestBody(bodyParameters)).build());
    }

    protected Response httpPatchAsResponse(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
    	checkImplementation(RestUrlKeys.PATCH);
        return executeRequest(prepareRequestBuilder(getRestUrl().readPatchUrl(), pathVariables, urlParameters)
                .patch(prepareRequestBody(bodyParameters)).build());
    }

    protected String httpPatchAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters, RestUrl restUrl) {
        return responseBodyAsText(httpPatchAsResponse(pathVariables, urlParameters, bodyParameters, restUrl));
    }

    protected String httpPatchAsText(RestParameters pathVariables, RestParameters urlParameters,
            RestParameters bodyParameters) {
        return responseBodyAsText(httpPatchAsResponse(pathVariables, urlParameters, bodyParameters));
    }

}
