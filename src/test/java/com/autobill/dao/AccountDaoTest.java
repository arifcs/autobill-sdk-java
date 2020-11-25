package com.autobill.dao;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APIConfigTest;
import com.autobill.model.AccountList;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDaoTest {

    @Test
    public void testRead(){
        APIConfig apiConfig = APIConfigTest.createTestApiConfig();
        AccountList accountList = AccountDao.readAll(apiConfig);
        assertNotNull(accountList);
        //assertEquals(accountList.accounts.size(),1);
        //System.out.println(accountList.accounts.get(0).id);
    }

}