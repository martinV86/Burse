package com.belhard.lesson;


import com.belhard.lesson.FactoryMetod.CriptaFactory;
import com.belhard.lesson.cripta.Cripta;
import com.belhard.lesson.dao.BitcoinDataBase;
import com.belhard.lesson.indicators.LarryU;
import com.belhard.lesson.indicators.RSI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import static org.jsoup.helper.HttpConnection.connect;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            var document = Jsoup.connect("https://currency.com/trading/platform/trade").get();
            var script = document.selectFirst("script");

            System.out.println(script.text());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("parsing from sait (demo)");
        BitcoinDataBase bitcoinDataBase = new BitcoinDataBase();
        ArrayList<Integer> endTragings = bitcoinDataBase.getEndTragings();
        ArrayList<Integer> startTragings = bitcoinDataBase.getStartTragings();
        ArrayList<Integer> idList = bitcoinDataBase.getIdList();
        Cripta bitcoin =new Cripta(startTragings,endTragings,idList);
        LarryU larryU=new LarryU(bitcoin);
        RSI rsi=new RSI(bitcoin);
        CriptaFactory criptaFactory=new CriptaFactory(rsi,larryU);
        System.out.println(criptaFactory.getSignalFactory());

    }
}
