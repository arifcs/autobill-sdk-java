package com.autobill.reader;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APICaller;
import com.autobill.connect.APIResource;
import com.autobill.model.Account;
import com.mashape.unirest.http.HttpMethod;

import java.util.List;

public class AccountReader {
    public static List<Account> readAll(APIConfig apiConfig){
        String response = APICaller.callResource(apiConfig, APIResource.ACCOUNT, HttpMethod.GET);
        System.out.println(response);
        return null;
    }
}
