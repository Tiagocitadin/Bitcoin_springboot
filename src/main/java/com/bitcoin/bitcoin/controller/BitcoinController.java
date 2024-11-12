package com.bitcoin.bitcoin.controller;

import com.bitcoin.bitcoin.model.Ticker;
import com.bitcoin.bitcoin.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinController {

    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/api/{currency}-price")
    public Ticker getCryptoPrice(@PathVariable String currency) {
        return bitcoinService.getTicker(currency);
    }
}
