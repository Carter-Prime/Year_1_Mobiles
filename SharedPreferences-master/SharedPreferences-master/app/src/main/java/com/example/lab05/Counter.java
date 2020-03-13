package com.example.lab05;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

class Counter implements LifecycleObserver {
    private int counterOnCreate;
    private int counterOnStart;
    private int counterOnResume;

    Counter(){

        this.counterOnCreate = 0;
        this.counterOnStart = 0;
        this.counterOnResume = 0;
    }

    void reset() {
        this.counterOnCreate = 0;
        this.counterOnStart = 0;
        this.counterOnResume = 0;
    }


    void plus(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                counterOnCreate += 1;
                break;
            case ON_START:
                counterOnStart += 1;
                break;
            case ON_RESUME:
                counterOnResume += 1;
                break;
            default:
        }
    }

    String getCounter(String counterType){
        String counter = "";
        switch (counterType) {
            case "onCreate":
                counter = Integer.toString(this.counterOnCreate);
                break;
            case "onStart":
                counter = Integer.toString(this.counterOnStart);
                break;
            case "onResume":
                counter = Integer.toString(this.counterOnResume);
                break;
        }
        return counter;
    }
    void setCounter(String counterType, String number){

        switch (counterType) {
            case "onCreate":
                this.counterOnCreate = Integer.parseInt(number);
                break;
            case "onStart":
                this.counterOnStart = Integer.parseInt(number);
                break;
            case "onResume":
                this.counterOnResume = Integer.parseInt(number);
                break;
        }

    }
}
