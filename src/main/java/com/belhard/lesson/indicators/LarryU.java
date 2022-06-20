package com.belhard.lesson.indicators;

import com.belhard.lesson.cripta.Cripta;

import java.util.ArrayList;
import java.util.Collections;

public class LarryU extends TradingResult implements CalculationLarryU {
    private int close;
    private int max;
    private int min;

    public LarryU(Cripta cripta) {
        super(cripta);
    }


    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }


    @Override
    public int getMax() {
        max = Collections.max(getCripta().getStartTragings());
        return max;
    }

    @Override
    public int getMin() {
        min = Collections.min(getCripta().getEndTragings());
        return min;
    }

    @Override
    public int close() {
        close = getCripta().getEndTragings().get(getCripta().getEndTragings().size() - 1);
        return close;
    }

    @Override
    public String LarryU() {
        int Larry = 100 * (getClose() - getMax()) / (getMax() - getMin());
        String signal = null;
        if (Larry < -80) {
            signal = "Larry: открыть полицию на покупку";
        }
        if (Larry > -20) {
            signal = "Larry: открыть полицию на продажу";
        }
        if (Larry > -80 && Larry < -20) {
            signal = null;
        }
        return signal;
    }
}
