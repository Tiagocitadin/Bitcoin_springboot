package com.bitcoin.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticker {

    @JsonProperty("ticker")
    private TickerData ticker;

    public TickerData getTicker() {
        return ticker;
    }

    public void setTicker(TickerData ticker) {
        this.ticker = ticker;
    }

    public static class TickerData {
        private double last;

        // Corrigido para retornar um double
        public double getLast() {
            return last;
        }

        public void setLast(double last) {
            this.last = last;
        }
    }
}
