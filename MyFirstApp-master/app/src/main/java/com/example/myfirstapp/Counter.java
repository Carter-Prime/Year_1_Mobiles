package com.example.myfirstapp;

class Counter {
    private int counter;
    private int min;
    private int max;

    Counter(int min, int max){
        this.counter = min;
        this.min = min;
        this.max = max;
    }

    void reset() {
        counter = min;
    }

    void minus() {
        if(counter > min) {
            counter -= 1;
        }
    }

    void plus() {
        if(counter < max) {
            counter += 1;
        }
    }

    String getCounter(){
        String counter;
        counter = Integer.toString(this.counter);
        return counter;
    }

    String hexadecimal() {
        return Integer.toHexString(this.counter);


    }
}
