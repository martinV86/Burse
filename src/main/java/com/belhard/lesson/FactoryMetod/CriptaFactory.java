package com.belhard.lesson.FactoryMetod;

import com.belhard.lesson.cripta.Cripta;
import com.belhard.lesson.indicators.LarryU;
import com.belhard.lesson.indicators.RSI;

import java.util.Collections;

public class CriptaFactory {
    private Cripta cripta;
    private LarryU larryU;
    private RSI rsi;

    public CriptaFactory(RSI rsi, LarryU larryU) {

        this.rsi = rsi;
        this.larryU = larryU;
    }

    String signalFactory;

    public String getSignalFactory() {

        if (rsi.calculationRSI() != null && larryU.LarryU() != null) {
            signalFactory = rsi.calculationRSI() + " " + larryU.LarryU();
        }
        if (rsi.calculationRSI() == null && larryU.LarryU() == null) {
            signalFactory = "требуется новый индикатор";
        }
        if (rsi.calculationRSI() != null && larryU.LarryU() == null) {
            signalFactory = rsi.calculationRSI();
        }
        if (larryU.LarryU() != null && rsi.calculationRSI() == null) {
            signalFactory = larryU.LarryU();
        }
        return signalFactory + " " + larryU.getMin() + " " + larryU.getMax();
    }
}
