package com.belhard.lesson.dao;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class BitcoinDataBase implements BitcoinDao {
    private int startTraging;
    private int endTraging;
    private int id;
    private ArrayList<Integer> startTragings;
    private ArrayList<Integer> endTragings;
    private ArrayList<Integer> idList;
    public Connection c;
    public Statement statement;

    public BitcoinDataBase() throws Exception {
        endTragings = new ArrayList<>();
        startTragings = new ArrayList<>();
        idList = new ArrayList<>();
        Properties properties = new Properties();
//    FileOutputStream out=new FileOutputStream("my properties");
//    properties.store(out,"comments");
        properties.load(new FileInputStream("my properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String db = properties.getProperty("db");
        c = DriverManager.getConnection(db, user, password);
        System.out.println("DB connection is successful");
        statement = c.createStatement();
        ResultSet rs = statement.executeQuery("select*from bitcoin");
        while (rs.next()) {

            id = rs.getInt("bargainning_id");
            idList.add(id);
            startTraging = rs.getInt("start_tragin");
            startTragings.add(startTraging);
            endTraging = rs.getInt("end_tragin");
            endTragings.add(endTraging);
        }


    }

    @Override
    public ArrayList<Integer> getStartTragings() {
        this.startTragings = startTragings;
        return startTragings;
    }

    @Override
    public ArrayList<Integer> getEndTragings() {
        this.endTragings = endTragings;
        return endTragings;
    }

    @Override
    public ArrayList<Integer> getIdList() {
        this.idList = idList;
        return idList;
    }
}
