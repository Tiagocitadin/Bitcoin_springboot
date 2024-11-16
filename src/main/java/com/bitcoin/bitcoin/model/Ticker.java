package com.bitcoin.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

    @JsonProperty("ticker")
    private TickerData ticker;

    public TickerData getTicker() {
        return ticker;
    }

    public void setTicker(TickerData ticker) {
        this.ticker = ticker;
    }

    // Classe interna para representar os dados do ticker
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TickerData {

        @JsonProperty("last")
        private double last;

        public double getLast() {
            return last;
        }

        public void setLast(double last) {
            this.last = last;
        }
    }
}
