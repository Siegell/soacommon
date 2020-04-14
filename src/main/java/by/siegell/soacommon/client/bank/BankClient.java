package by.siegell.soacommon.client.bank;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class BankClient {

    private static final String BANK_SERVICE_URL = "http://127.0.0.1:8041";
    private static final String ACCOUNT = "/bank_account";
    private static final String DEFAULT_PATH = "/";
    private static final String CREATED_AUTOMATICALLY = "Created automatically, please verify this user";

    public UUID createAccount(String details) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = BANK_SERVICE_URL + ACCOUNT + DEFAULT_PATH;
        HttpEntity<String> request =
                new HttpEntity<>(new JSONObject().put("details", details).toString(), headers);
        Account account = restTemplate.postForObject(url, request, Account.class);
        return account.getId();
    }

    public UUID createAccount() {
        return createAccount(CREATED_AUTOMATICALLY);
    }
}
