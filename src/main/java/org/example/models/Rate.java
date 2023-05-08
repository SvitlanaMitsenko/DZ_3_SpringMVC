package org.example.models;

import lombok.Data;

@Data
public class Rate {
    float rate;
    String currency;

    public Rate(String currency, float rate) {
        this.currency = currency;
        this.rate = rate;
    }
}
