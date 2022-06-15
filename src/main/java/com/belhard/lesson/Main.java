package com.belhard.lesson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static org.jsoup.helper.HttpConnection.connect;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        try {
            var document = Jsoup.connect("https://currency.com/trading/platform/trade").get();
var script=document.selectFirst("script");

            System.out.println(script.text());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
