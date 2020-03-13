package com.example.lab06_listview;

class President {

    private String name;
    private int dateFrom;
    private int dateTo;
    private String description;


    President(String name, int dateFrom, int dateTo, String description) {
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public String getinfo(){
      return "President name is: " + this.name +" They were in power from " + this.dateFrom + " until "
              + this.dateTo + ".\nDescription: " + this.description;
    }

    String getName(){
        return this.name;
    }

    int getDateFrom(){
        return this.dateFrom;
    }

    int getDateTo(){
        return this.dateTo;
    }

    String getDescription(){
        return this.description;
    }
}
