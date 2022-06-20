package com.belhard.lesson.cripta;

import java.util.ArrayList;

public class Cripta {
    private ArrayList<Integer> startTragings;
    private ArrayList<Integer> endTragings;
    private ArrayList<Integer> _idList;

    public Cripta(ArrayList<Integer> startTragings, ArrayList<Integer> endTragings, ArrayList<Integer> _idList) {
        this.startTragings = startTragings;
        this.endTragings = endTragings;
        this._idList = _idList;
    }

    public ArrayList<Integer> getStartTragings() {
        return startTragings;
    }

    public ArrayList<Integer> getEndTragings() {
        return endTragings;
    }

    public ArrayList<Integer> get_idList() {
        return _idList;
    }
}
