package com.autobill.connect;

import com.autobill.APIException;
import com.autobill.TokenExpiredException;
import com.autobill.UnexpectedResponseException;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class APICaller {
    public static String getAccessToken(APIConfig apiConfig, String code){
        try {
            String requestBody = "{  \"grant_type\": \"authorization_code\", " +
                    " \"code\": \""+code+"\", " +
                    " \"client_id\": \""+apiConfig.getClientId()+"\", " +
                    " \"client_secret\": \""+apiConfig.getClientSecret()+"\", " +
                    " \"redirect_uri\": \""+apiConfig.getRedirectUrl()+"\"}";
            HttpResponse<String> response = Unirest.post(apiConfig.getApiUrl()+"/api/v1/oauth2/token")
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .body(requestBody)
                    .asString();
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String renewToken(APIConfig apiConfig) {
        try {
            HttpResponse<String> response = Unirest.post(apiConfig.getApiUrl()+"/api/v1/oauth2/token")
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .body("{  \"refresh_token\": \""+apiConfig.getRefreshToken()+"\", " +
                            " \"grant_type\": \"refresh_token\", " +
                            " \"client_id\": \""+apiConfig.getClientId()+"\", " +
                            " \"client_secret\": \""+apiConfig.getClientSecret()+"\", " +
                            " \"redirect_uri\": \""+apiConfig.getRedirectUrl()+"\"}")
                    .asString();
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String callByPathAndMethod(APIConfig apiConfig, String path, HttpMethod method, String data) throws APIException {
        String url = apiConfig.getApiUrl() + path;
        HttpResponse response = null;
        try {
            switch (method){
                case GET :
                    response = Unirest.get(url)
                            .header("authorization", "Bearer "+apiConfig.getAccessToken())
                            .header("cache-control", "no-cache")
                            .asString();
                    break;
                case POST :
                    response = Unirest.post(url)
                            .header("authorization", "Bearer "+apiConfig.getAccessToken())
                            .header("cache-control", "no-cache")
                            .body(data)
                            .asString();
                    break;
                case PATCH:
                    response = Unirest.patch(url)
                            .header("authorization", "Bearer "+apiConfig.getAccessToken())
                            .header("cache-control", "no-cache")
                            .body(data)
                            .asString();
                    break;
                case DELETE:
                    response = Unirest.delete(url)
                            .header("authorization", "Bearer "+apiConfig.getAccessToken())
                            .header("cache-control", "no-cache")
                            .asString();
                    break;

            }
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new APIException();
        }
        if(response.getStatus()>=200 && response.getStatus() <=299){
            return response.getBody().toString();
        }
        if(response.getStatus() == 401){
            throw new TokenExpiredException();
        }
        return null;
    }

    public static String callResource(APIConfig apiConfig, APIResource apiResource, HttpMethod method, String data, String id) throws APIException{
        String path = "/api/v1/" + apiResource.toString();
        if(id != null){
            path = path + "/" + id;
            if(method.equals(HttpMethod.PATCH)){
                path = path + "/information";
            }
        }
        return callByPathAndMethod(apiConfig, path, method, data);
    }
}
