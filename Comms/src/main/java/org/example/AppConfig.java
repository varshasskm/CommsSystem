package org.example;

import org.example.model.AccountType;
import org.example.model.ChannelType;
import org.example.model.vendor.Account;
import org.example.model.vendor.Channel;
import org.example.model.vendor.Vendor;
import org.example.service.VendorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public VendorService vendorService() {

        //hardcoding the vendors for simplicity
        List<Vendor> vendors = new ArrayList<>();


        //creating a vendor with two accounts - TRANSACTIONAL and PROMOTIONAL with different authentication methods and one Channel - EMAIL.
        Vendor vendor1 = new Vendor("vendor1","1","dummyAvailabiltyUrl");
        vendor1.addAccount(AccountType.PROMOTIONAL,new Account(AccountType.PROMOTIONAL, new String[]{"Authorization: Bearer YOUR_ACCESS_TOKEN"}));
        Account acc = new Account(AccountType.TRANSACTIONAL, new String[]{"username: XXX","password:YYY"});
        vendor1.addAccount(AccountType.TRANSACTIONAL,acc);
        vendor1.addChannel(ChannelType.EMAIL,new Channel(ChannelType.EMAIL,"dummyAPIUrl"));

        //creating another vendor with one account - TRANSACTIONAL and two channels - email and sms.
        Vendor vendor2 = new Vendor("vendor2","2","dummyAvailabiltyUrl");
        vendor2.addAccount(AccountType.TRANSACTIONAL,new Account(AccountType.TRANSACTIONAL, new String[]{"Authorization: Bearer YOUR_ACCESS_TOKEN"}));
        vendor2.addChannel(ChannelType.EMAIL,new Channel(ChannelType.EMAIL,"dummyAPIUrl"));
        vendor2.addChannel(ChannelType.SMS,new Channel(ChannelType.SMS,"dummyAPIUrl"));


        vendors.add(vendor1);
        vendors.add(vendor2);

        // Create and return VendorService with the list of vendors
        return new VendorService(vendors);
    }
}
