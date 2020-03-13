package com.example.lab06_listview;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PresidentDetailsActivity extends AppCompatActivity {

    TextView tvName, tvDateFrom, tvDateTo, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_detail);
        tvName = findViewById(R.id.textViewName);
        tvDateFrom = findViewById(R.id.textViewDateFrom);
        tvDateTo = findViewById(R.id.textViewDateTo);
        tvDescription = findViewById(R.id.textViewDescription);

        int i = getIntent().getIntExtra("list", 0);

        tvName.setText(MySingleton.getInstance().getPresident(i).getName());
        tvDateFrom.setText(String.valueOf(MySingleton.getInstance().getPresident(i).getDateFrom()));
        tvDateTo.setText(String.valueOf(MySingleton.getInstance().getPresident(i).getDateTo()));
        tvDescription.setText(MySingleton.getInstance().getPresident(i).getDescription());


    }
}
