package com.bitcoin.bitcoin.service;

import com.bitcoin.bitcoin.model.Ticker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitcoinService {

    private static final String API_URL_TEMPLATE = "https://www.mercadobitcoin.net/api/%s/ticker/";

    public Ticker getTicker(String currency) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = String.format(API_URL_TEMPLATE, currency.toUpperCase());
        return restTemplate.getForObject(apiUrl, Ticker.class);
    }
}
