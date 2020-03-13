package com.example.lab06_listview;

import java.util.ArrayList;


class MySingleton {

    private static final MySingleton mInstance = new MySingleton();

    private ArrayList<President> list;

    static MySingleton getInstance() {

        return mInstance;
    }

    private MySingleton() {

        list = new ArrayList<>();
    }

    ArrayList<President> getPresidents() {

        return this.list;
    }

    void add(President element) {

        list.add(element);
    }

    President getPresident(int i) {

        return this.list.get(i);

    }
}
