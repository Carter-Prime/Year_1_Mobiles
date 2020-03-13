package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Counter counter;
    private TextView counterShow;
    private View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.plusBtn:counter.plus();
                break;
                case R.id.minusBtn: counter.minus();
                break;
                default: counter.reset();
            }
            if(radioGroup.getCheckedRadioButtonId() == R.id.hexadecimal) {
                setHex();
            }else setText();
        }
    };

    private RadioGroup.OnCheckedChangeListener myGroup = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId == R.id.hexadecimal) {
                setHex();
            } else {
                setText();
            }
        }
    };
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusBtn, minusBtn;
        ImageButton resetBtn;
        counter = new Counter(985, 100000000);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        resetBtn = findViewById(R.id.imageButton);
        counterShow = findViewById(R.id.counterShow);
        radioGroup = findViewById(R.id.numberConvertGroup);


        plusBtn.setOnClickListener(myClick);
        minusBtn.setOnClickListener(myClick);
        resetBtn.setOnClickListener(myClick);
        radioGroup.setOnCheckedChangeListener(myGroup);
        setText();
    }

    public void setText(){
        counterShow.setText(counter.getCounter());
    }

    public void setHex(){
        counterShow.setText(counter.hexadecimal());
    }
}
