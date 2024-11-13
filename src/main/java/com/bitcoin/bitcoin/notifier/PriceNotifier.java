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

    // Valor alvo configurável
    private static final double TARGET_PRICE = 0;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            // Obtendo o ticker da moeda desejada (exemplo: "BTC")
            Ticker ticker = bitcoinService.getTicker("BTC");

            // Verificação de nulos
            if (ticker != null && ticker.getTicker() != null) {
                // Obter o preço atual como double
                double currentPrice = ticker.getTicker().getLast();

                // Verificação do preço
                if (currentPrice >= TARGET_PRICE) {
                    System.out.println("⚠️ Alerta! O preço do Bitcoin (BTC) atingiu o valor alvo: R$ " + currentPrice);
                } else {
                    System.out.println("Preço atual do Bitcoin (BTC): R$ " + currentPrice);
                }
            } else {
                System.err.println("Erro: Dados do ticker estão nulos.");
            }
        } catch (Exception e) {
            System.err.println("Erro inesperado durante a execução do job: " + e.getMessage());
        }
    }
}
