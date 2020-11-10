package com.autobill.connect;

import com.autobill.Constants;

import java.io.File;

public class APIConfig {
    private String apiUrl;
    private String appUrl;
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
    private String accessToken;
    private String refreshToken;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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
        this.appUrl = Constants.DEFAULT_APP_URL;
        this.apiUrl = Constants.DEFAULT_API_URL;
        this.clientId = Constants.CLIENT_ID;
        this.redirectUrl = Constants.REDIRECT_URL;
    }

    public static APIConfig readConfig(){
        return new APIConfig();
    }

    public String getAuthorizeUrl(){
        return appUrl + "/api/v1/oauth2/authorize?client_id="+ clientId +"&redirect_uri="+ redirectUrl +"&response_type=code";
    }
    protected File getUserDir(){
        return new File(System.getProperty("user.dir"));
    }

    @Override
    public String toString(){
        return "apiURL = "+ apiUrl +"\n"+
                "appUrl = "+ appUrl +"\n"+
                "clientId = "+clientId+"\n"+
                "clientSecret = "+ clientSecret +"\n"+
                "refreshToken = "+ refreshToken +"\n"+
                "accessToken = "+ accessToken +"\n"+
                "redirectUrl = "+ redirectUrl +"\n";
    }
}
