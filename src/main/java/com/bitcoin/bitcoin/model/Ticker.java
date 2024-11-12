package com.bitcoin.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ticker {

    private String high;
    private String low;
    private String vol;
    private String last;
    private String buy;
    private String sell;
    private Long date;

    @JsonProperty("ticker")
    private Ticker ticker;
}
