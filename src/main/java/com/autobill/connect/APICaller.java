package com.autobill.connect;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class APICaller {
    public static String getAccessToken(APIConfig apiConfig, String code){
        try {
            String requestBody = "{  \"grant_type\": \"authorization_code\", " +
                    " \"code\": \""+code+"\", " +
                    " \"client_id\": \""+apiConfig.getClientId()+"\", " +
                    " \"client_secret\": \""+apiConfig.getClientSecret()+"\", " +
                    " \"redirect_uri\": \""+apiConfig.getRedirectUrl()+"\"}";
            System.out.println(requestBody);
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

    public static String callByPathAndMethod(APIConfig apiConfig, String path, HttpMethod method, String data){
        String url = apiConfig.getApiUrl() + path;
        System.out.println(data);
        try {
            switch (method){
                case GET : return Unirest.get(url)
                        .header("authorization", "Bearer "+apiConfig.getAccessToken())
                        .header("cache-control", "no-cache")
                        .asString().getBody();
                case POST :
                    return Unirest.post(url)
                            .header("authorization", "Bearer "+apiConfig.getAccessToken())
                            .header("cache-control", "no-cache")
                            .body(data)
                            .asString().getBody();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String callResource(APIConfig apiConfig, APIResource apiResource, HttpMethod method, String data){
        String path = "/api/v1/" + apiResource.toString();
        return callByPathAndMethod(apiConfig, path, method, data);
    }
}
