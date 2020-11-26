package com.autobill.dao;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APIConfigTest;
import com.autobill.model.Account;
import com.autobill.model.AccountList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountDaoTest {

    @Test
    public void testRead(){
        APIConfig apiConfig = APIConfigTest.createTestApiConfig();
        List<Account> accountList = AccountDao.readAll(apiConfig);
        assertNotNull(accountList);
    }

}