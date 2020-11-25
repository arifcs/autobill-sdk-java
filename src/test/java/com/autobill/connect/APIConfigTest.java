package com.autobill.connect;

import org.junit.Test;

import static org.junit.Assert.*;

public class APIConfigTest {
    @Test
    public void testAPICOnfig(){
        assert 1==1;
    }

    public static APIConfig createTestApiConfig(){
        APIConfig apiConfig = APIConfig.readConfig();
        apiConfig.setClientId("DDgNOjcOCAsCCzQHBQs6YTYCDjY6NAIJBzoJAjcNBQYCOw0IBwgGDDgJOQs6Ag4FDQYCBQ4KDjk=");
        apiConfig.setClientSecret("DjoPPDkQCg0ECmM8ODg9NDAEBw44NgQLCg4KBBAOOwgECBAODjg4OQ0NDzwOBBAHDwgEDws8Ojk=");
        apiConfig.setAccessToken("LlovXFkwKi0kWjAwWyspYTkkLC4rYSQrKy9bJFguWS0kLFtYWVwpKDBaKS9YJDAnLygkLi8tKCo=");
        apiConfig.setRefreshToken("M180YV41LzIpMGI0MV5iNjQpYF5eZCkwNDI0KV40YTMpXi0sMF4yX19dNF5iKTUsNC0pXjQzNDQ=");
        apiConfig.setRedirectUrl("http://localhost:8080/callBack/index");
        return apiConfig;
    }

}