package org.example.model.vendor;

import org.example.model.ChannelType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Channel {
    private ChannelType channelType;
    private String ApiUrl;

    public Channel(ChannelType channeltype, String apiUrl) {
        this.channelType = channeltype;
        this.ApiUrl = apiUrl;
    }

    public ChannelType getChanneltype() {
        return channelType;
    }
    public void setChanneltype(ChannelType channeltype) {
        this.channelType = channeltype;
    }


    public String getApiUrl() {
        return ApiUrl;
    }
    public void setApiUrl(String apiUrl) {
        ApiUrl = apiUrl;
    }

    private HttpURLConnection createHttpURLConnection(String[] authenticationHeaders) throws IOException {
        URL url = new URL(ApiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        for (String header : authenticationHeaders) {
            String[] parts = header.split(":");
            connection.setRequestProperty(parts[0], parts[1]);
        }
        return connection;
    }

    public boolean sendNotification(String[] authenticationHeaders, String message) {

            //HttpURLConnection connection = createHttpURLConnection(authenticationHeaders);
            // set message body, headers, etc, connection.setRequestMethod
            //int responseCode = connection.getResponseCode();
            //instead of making the api call, assuming it returned 200.

            int responseCode = HttpURLConnection.HTTP_OK;

            return responseCode == HttpURLConnection.HTTP_OK;

    }



}
