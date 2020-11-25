package com.autobill.model;

/*
https://json2csharp.com/json-to-pojo
 */

import java.util.List;

public class Account{
    public String status;
    public String id;
    public String name;
    public String display_name;
    public String description;
    public String type;
    public String email_address;
    public String image_uri;
    public String time_zone;
    public Tax tax;
    public String accounting_code;
    public String pricing_level;
    public List<CommunicationPreference> communication_preference;
    public String website;
    public String linkedin;
    public String twitter;
    public String facebook;
    public String total_revenue;
    public String monthly_recurring_revenue;
    public String total_collected;
    public String total_refunded;
    public String total_outstanding;
    public String total_overdue;
    public String total_balance;
    public String total_credit_balance;
    public String total_orders;
    public String total_active_orders;
    public String last_reactivated_on;
    public String last_cancelled_on;
    public String deleted_on;
    public String created_by;
    public String created_on;
    public String last_updated_by;
    public String last_updated_on;
    public String uuid;
    public String version;
    public BillingPreferences billing_preferences;
    public List<Contact> contacts;
    public List<Object> payment_methods;
}
