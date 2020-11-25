package com.autobill.dao;

import com.autobill.connect.APIConfig;
import com.autobill.connect.APICaller;
import com.autobill.connect.APIResource;
import com.autobill.model.AccountList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpMethod;

import java.io.IOException;

public class AccountDao {
    public static AccountList readAll(APIConfig apiConfig){
        String response = APICaller.callResource(apiConfig, APIResource.ACCOUNT, HttpMethod.GET);
        //String response = "{\"accounts\":[{\"status\":\"ACTIVE\",\"id\":\"PTH6KM\",\"name\":\"Name\",\"display_name\":\"Display\",\"description\":\"\",\"type\":\"CUSTOMER\",\"email_address\":\"arif@rahman.com\",\"image_uri\":\"\",\"time_zone\":\"Australia/Adelaide\",\"tax\":{\"uuid\":\"6CD8605A-CA5B-49F2-9795-B2CEDC564663\",\"configuration\":\"AUS\",\"code\":\"GST\",\"rate\":\"10.0000\"},\"accounting_code\":\"\",\"pricing_level\":\"\",\"communication_preference\":[{\"media\":\"EMAIL\",\"enabled\":\"NO\"}],\"website\":\"\",\"linkedin\":\"\",\"twitter\":\"\",\"facebook\":\"\",\"total_revenue\":\"0.00\",\"monthly_recurring_revenue\":\"\",\"total_collected\":\"0.00\",\"total_refunded\":\"0.00\",\"total_outstanding\":\"0.00\",\"total_overdue\":\"0.00\",\"total_balance\":\"0.00\",\"total_credit_balance\":\"0.00\",\"total_orders\":\"0\",\"total_active_orders\":\"\",\"last_reactivated_on\":\"\",\"last_cancelled_on\":\"\",\"deleted_on\":\"\",\"created_by\":\"Implementer\",\"created_on\":\"2020-11-25\",\"last_updated_by\":\"\",\"last_updated_on\":\"\",\"uuid\":\"2EF5851E-2D34-4E09-B39B-CB91292386AC\",\"version\":\"2\",\"billing_preferences\":{\"communication_profile\":\"\",\"payment_processor\":\"\",\"payment_mode\":\"\",\"payment_term\":\"\",\"payment_term_alignment\":\"\"},\"contacts\":[{\"type\":\"CONTACT_1\",\"type_display_name\":\"Billing Contact\",\"billing_contact\":\"TRUE\",\"shipping_contact\":\"FALSE\",\"salutation\":\"\",\"designation\":\"\",\"first_name\":\"\",\"last_name\":\"\",\"email\":{\"address\":\"\",\"do_not_email\":\"\"},\"address_line_1\":\"\",\"address_line_2\":\"\",\"post_code\":\"3000\",\"city\":\"Melbourne\",\"state\":\"Victoria\",\"country\":\"Australia\",\"phone\":{\"country_code\":\"\",\"area_code\":\"\",\"number\":\"\",\"full\":\"\",\"do_not_call\":\"\"},\"fax\":{\"country_code\":\"\",\"area_code\":\"\",\"number\":\"\",\"full\":\"\",\"do_not_call\":\"\"},\"mobile\":{\"country_code\":\"\",\"area_code\":\"\",\"number\":\"\",\"full\":\"\",\"do_not_call\":\"\"},\"receive_billing_information\":\"TRUE\",\"created_by\":\"Implementer\",\"created_on\":\"2020-11-25\",\"last_updated_by\":\"\",\"last_updated_on\":\"\",\"uuid\":\"D015FF53-6681-44E2-9145-D6556BD8DB18\",\"version\":\"1\"}],\"payment_methods\":[]}]}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        AccountList accountList = null;
        try {
            accountList = objectMapper.readValue(response, AccountList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }
}