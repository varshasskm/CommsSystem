package org.example.model.vendor;

import org.example.model.AccountType;
import org.example.model.ChannelType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Vendor {
    private String vendorName;
    private String vendorId;
    private String availabilityUrl;
    private Map<ChannelType, Channel> channels;
    private Map<AccountType, Account> accounts;

    public Vendor(String vendorName, String vendorId, String availabilityUrl){
        this.vendorName = vendorName;
        this.vendorId = vendorId;
        this.availabilityUrl = availabilityUrl;
        this.channels = new HashMap<ChannelType,Channel>();
        this.accounts = new HashMap<AccountType,Account>();
    }

    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorId() {
        return vendorId;
    }
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Map<ChannelType, Channel> getChannels() {
        return channels;
    }
    public void setChannels(Map<ChannelType, Channel> channels) {
        this.channels = channels;
    }

    public void addChannel(ChannelType channelType, Channel channel){
        this.channels.put(channelType,channel);
    }

    public Map<AccountType, Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Map<AccountType, Account> accounts) {
        this.accounts = accounts;
    }
    public void addAccount(AccountType accountType, Account account){
        this.accounts.put(accountType,account);
    }


    public boolean isVendorAvailable(AccountType accountType)  {
        return accounts.get(accountType).isVendorAccountAvailable(availabilityUrl);
    }

    public boolean sendNotification(AccountType accountType,ChannelType channelType, String message,String recepientId)  {
        String[] authenticationHeaders = accounts.get(accountType).getAuthenticationHeaders();
        return channels.get(channelType).sendNotification(authenticationHeaders, message,recepientId);
    }


}
