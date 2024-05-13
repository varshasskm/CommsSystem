package org.example.model;

public class CommReq {
    private String id;
    private ChannelType channelType;
    private AccountType type;
    private String recepientId;
    private String message;

    public CommReq(String id, ChannelType channelType, AccountType type,String recepientId, String message) {
        this.id = id;
        this.channelType = channelType;
        this.type = type;
        this.recepientId = recepientId;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public AccountType getType() {
        return type;
    }
    public void setType(AccountType type) {
        this.type = type;
    }

    public String getRecepientId() {
        return recepientId;
    }

    public void setRecepientId(String recepientId) {
        this.recepientId = recepientId;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isValid(){
        //write logic to validate
        if(true){
            return true;
        }
        return false;
    };
}
