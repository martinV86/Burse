package com.belhard.lesson.indicators;

import com.belhard.lesson.cripta.Cripta;

import java.util.ArrayList;

public class RSI extends TradingResult implements CalculationRSI {

    private double rs;
    private double ema_u;
    private double ema_d;
    public int rsi;


    public RSI(Cripta cripta) {
        super(cripta);
    }


    public double getRs() {
        return rs;
    }

    public void setRs(double rs) {
        this.rs = rs;
    }

    public void setEma_u(double ema_u) {
        this.ema_u = ema_u;
    }

    public void setEma_d(double ema_d) {
        this.ema_d = ema_d;
    }

    public double getEma_u() {
        return ema_u;
    }

    public double getEma_d() {
        return ema_d;
    }

    @Override
    public void calculationEMA() {
        ema_u = 0.0;
        int down = 0;
        ema_d = 0.0;
        int up = 0;
        int a = 0;
        int ema_down;
        int ema_up;
        while (a != getCripta().getStartTragings().size()) {
            if (getCripta().getStartTragings().get(a) > getCripta().getEndTragings().get(a)) {
                ema_up = getCripta().getStartTragings().get(a) - getCripta().getEndTragings().get(a);
                up = up++;
                ema_u = ema_u + ema_up;
            }
            if (getCripta().getStartTragings().get(a) < getCripta().getEndTragings().get(a)) {
                ema_down = getCripta().getEndTragings().get(a) - getCripta().getStartTragings().get(a);
                down = down++;
                ema_d = ema_d + ema_down;
            }
            a = a++;
        }
        ema_u = ema_u / up;
        ema_d = ema_d / down;

    }

    @Override
    public void calculationRS() {
        rs = ema_u / ema_d;

    }

    @Override
    public String calculationRSI() {
        String signal = null;
        rsi = (int) (100 - (100 / (1 + rs)));
        if (rsi > 70) {
            signal = "RSI: перекупленность - сигнал на продажу";
        }
        if (rsi < 40) {
            signal = "RSI: перепродонность - сигнал на покупку";
        }
        if (rsi > 40 && rsi < 70) {
            signal = null;
        }
        return signal;
    }
}
