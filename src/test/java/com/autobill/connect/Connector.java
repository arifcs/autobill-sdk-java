package com.autobill.connect;

import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {
    private APIConfig apiConfig;
    public Connector(APIConfig apiConfig){
        this.apiConfig = apiConfig;
    }
    public Connector(){
        this(APIConfig.readConfig());
    }
    public APIConfig getApiConfig() {
        return apiConfig;
    }
    public boolean connect(){
        try{
            URL url = new URL(apiConfig.getAppUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
