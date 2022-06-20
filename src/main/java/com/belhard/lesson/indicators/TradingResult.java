package com.belhard.lesson.indicators;

import com.belhard.lesson.cripta.Cripta;

import java.util.ArrayList;

public abstract class TradingResult {
    private Cripta cripta;


    public TradingResult(Cripta cripta) {
        this.cripta = cripta;

    }

    public Cripta getCripta() {
        return cripta;
    }
}
