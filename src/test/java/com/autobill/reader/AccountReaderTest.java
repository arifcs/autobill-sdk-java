package com.autobill.reader;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APIConfigTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountReaderTest {

    @Test
    public void testRead(){
        APIConfig apiConfig = APIConfigTest.createTestApiConfig();
        AccountReader.readAll(apiConfig);
    }

}