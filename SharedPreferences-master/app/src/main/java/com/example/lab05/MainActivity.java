package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvOnCreate, tvOnStart,tvOnResume;
    Button resetBtn;
    SharedPreferences sharedPreferences;
    String counterCreate, counterStart, counterResume;
    Counter counter = new Counter();

    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter.reset();
            tvOnCreate.setText(counter.getCounter("onCreate"));
            tvOnStart.setText(counter.getCounter("onStart"));
            tvOnResume.setText(counter.getCounter("onResume"));
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOnCreate = findViewById(R.id.tvOnCreationCounter);
        tvOnStart = findViewById(R.id.tvOnStartCounter);
        tvOnResume = findViewById(R.id.tvOnResumeCounter);
        resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(myClick);

        Log.d("TAG KEY ","onCreate was called");

        sharedPreferences = getSharedPreferences("Counter", Context.MODE_PRIVATE);

        counterCreate = sharedPreferences.getString("onCreate", "0");
        counter.setCounter("onCreate", counterCreate);
        tvOnCreate.setText(counterCreate);
        counterStart = sharedPreferences.getString("onStart", "0");
        counter.setCounter("onStart", counterStart);
        tvOnStart.setText(counterStart);
        counterResume = sharedPreferences.getString("onResume", "0");
        counter.setCounter("onResume", counterResume);
        tvOnResume.setText(counterResume);
        counter.plus(Lifecycle.Event.ON_CREATE);
        tvOnCreate.setText(counter.getCounter("onCreate"));
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG KEY ","onStart was called");
        counter.plus(Lifecycle.Event.ON_START);
        tvOnStart.setText(counter.getCounter("onStart"));
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG KEY ","onResume was called");
        counter.plus(Lifecycle.Event.ON_RESUME);
        tvOnResume.setText(counter.getCounter("onResume"));
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG KEY ","onPause was called");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String counterCreate = tvOnCreate.getText().toString();
        String counterStart = tvOnStart.getText().toString();
        String counterResume = tvOnResume.getText().toString();
        editor.putString("onCreate", counterCreate);
        editor.putString("onStart", counterStart);
        editor.putString("onResume", counterResume);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG KEY ","onStop was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG KEY ","onRestart was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG KEY ","onDestroy was called");
    }

}
