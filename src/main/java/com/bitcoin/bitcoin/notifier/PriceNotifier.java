package com.bitcoin.bitcoin.notifier;

import com.bitcoin.bitcoin.model.Ticker;
import com.bitcoin.bitcoin.service.BitcoinService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceNotifier implements Job {

    @Autowired
    private BitcoinService bitcoinService;

    private final double targetPrice = 180000.0;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Passando a moeda desejada (exemplo: "BTC")
        Ticker ticker = bitcoinService.getTicker("BTC");
        if (ticker != null && ticker.getTicker() != null) {
            double currentPrice = Double.parseDouble(ticker.getTicker().getLast());
            if (currentPrice >= targetPrice) {
                System.out.println("⚠️ Alerta! O preço do Bitcoin (BTC) atingiu o valor alvo: R$ " + currentPrice);
            } else {
                System.out.println("Preço atual do Bitcoin (BTC): R$ " + currentPrice);
            }
        }
    }
}
