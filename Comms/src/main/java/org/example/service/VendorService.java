package org.example.service;

import org.example.model.AccountType;
import org.example.model.ChannelType;
import org.example.model.CommReq;
import org.example.model.vendor.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VendorService {
    private List<Vendor> vendorList;

    public VendorService(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public void addVendor(Vendor vendor) {
        this.vendorList.add(vendor);
    }


    public String SendNotification(CommReq commReq)  {
        ChannelType channelType = commReq.getChannelType();
        AccountType accountType = commReq.getType();
        String message = commReq.getMessage();

        for(Vendor vendor : vendorList){
            if(vendor.getAccounts().get(accountType) != null){
                if(vendor.getChannels().get(channelType)!=null){
                    if(vendor.isVendorAvailable(accountType)){
                        if(vendor.sendNotification(accountType,channelType,message)){
                            return "The communication has been processed successfully";
                        }
                    }
                }
            }
        }
        return "No vendor available at the moment to cater to this request";
    }
}
