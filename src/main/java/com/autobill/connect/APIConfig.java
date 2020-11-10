package com.autobill.connect;

import com.autobill.Constants;

import java.io.File;

public class APIConfig {
    private String apiURL;
    private String appURL;
    private String clientID;
    private String clientSecret;
    private String redirectURL;
    private String accessToken;
    private String refreshToken;

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public APIConfig() {
        this.appURL = Constants.DEFAULT_APP_URL;
        this.apiURL = Constants.DEFAULT_API_URL;
        this.clientID = Constants.CLIENT_ID;
        this.redirectURL = Constants.REDIRECT_URL;
    }

    public static APIConfig readConfig(){
        return new APIConfig();
    }

    public String getAuthorizeUrl(){
        return appURL + "/api/v1/oauth2/authorize?client_id="+clientID +"&redirect_uri="+redirectURL+"&response_type=code";
    }



    protected File getUserDir(){
        return new File(System.getProperty("user.dir"));
    }
}
