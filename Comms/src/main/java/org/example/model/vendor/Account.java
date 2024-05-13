package org.example.model.vendor;

import org.example.model.AccountType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Account {
    private AccountType accountType;
    private String[] authenticationHeaders;

    public Account(AccountType accountType, String[] authenticationHeaders) {
        this.accountType = accountType;
        this.authenticationHeaders = authenticationHeaders;
    }

    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public String[] getAuthenticationHeaders() {
        return authenticationHeaders;
    }
    public void setAuthenticationHeaders(String[] authenticationHeaders) {
        this.authenticationHeaders = authenticationHeaders;
    }

    private HttpURLConnection createHttpURLConnection(String availabilityUrl) throws IOException {
        URL url = new URL(availabilityUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        for (String header : authenticationHeaders) {
            String[] parts = header.split(":");
            connection.setRequestProperty(parts[0], parts[1]);
        }
        connection.setRequestMethod("GET");
        return connection;
    }

    public boolean isVendorAccountAvailable(String availabilityUrl)  {
            //HttpURLConnection connection = createHttpURLConnection(availabilityUrl);
            //int responseCode = connection.getResponseCode();
            //instead of making the api call, assuming it returned 200.
            int responseCode = HttpURLConnection.HTTP_OK;

            return responseCode == HttpURLConnection.HTTP_OK;


    }
}
