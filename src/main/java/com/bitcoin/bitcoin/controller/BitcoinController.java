package com.bitcoin.bitcoin.controller;

import com.bitcoin.bitcoin.model.Ticker;
import com.bitcoin.bitcoin.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BitcoinController {

    @Autowired
    private BitcoinService bitcoinService;

    @GetMapping("/api/{currency}-price")
    public ResponseEntity<Map<String, Object>> getCryptoPrice(@PathVariable String currency) {
        Ticker ticker = bitcoinService.getTicker(currency);

        // Verificar se o ticker foi encontrado e contém o campo "last"
        if (ticker != null && ticker.getTicker() != null && ticker.getTicker().getLast() > 0) {
            double price = ticker.getTicker().getLast();
            Map<String, Object> response = new HashMap<>();
            response.put("price", price);
            return ResponseEntity.ok(response);
        } else {
            // Retornar 404 se o preço não for encontrado
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Preço não encontrado para a moeda: " + currency);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
