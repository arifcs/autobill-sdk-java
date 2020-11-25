package com.autobill.reader;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APIConfigTest;
import com.autobill.model.AccountList;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountReaderTest {

    @Test
    public void testRead(){
        APIConfig apiConfig = APIConfigTest.createTestApiConfig();
        AccountList accountList = AccountReader.readAll(apiConfig);
        assertNotNull(accountList);
        //assertEquals(accountList.accounts.size(),1);
        //System.out.println(accountList.accounts.get(0).id);
    }

}