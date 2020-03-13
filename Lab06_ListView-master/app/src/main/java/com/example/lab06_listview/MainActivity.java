package com.example.lab06_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  {
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySingleton president = MySingleton.getInstance();
        president.add(new President("Stahlberg, Kaarlo Juho", 1919, 1925, "Eka presidentti"));
        president.add(new President("Relander, Lauri Kristian", 1925, 1931, "Toka presidentti"));
        president.add(new President("Svinhufvud, Pehr, Evind", 1931, 1937, "Kolmas presidentti"));
        president.add(new President("Kallio, Kyosti", 1937, 1940, "Neljas presidentti"));
        president.add(new President("Ryti, Risto Heikki", 1940, 1944, "Viides presidentti"));
        president.add(new President("Mannerheim, Carl Gustav Emil", 1944, 1946, "Kuudes presidentti"));
        president.add(new President("Paasikivi, Juho Kusti", 1946, 1956, "Äkäinen ukko"));
        president.add(new President("Kekkonen, Urho Kaleva", 1956, 1982, "Pelimies"));
        president.add(new President("Koivisto, Mauno Henrik", 1982, 1994, "Manu"));
        president.add(new President("Ahtisaari, Martti Oiva Kalevi", 1994, 2000, "Mahtisaari"));
        president.add(new President("Halonen, Tarja Kaarina", 2000, 2012, "Eka naispreseidentti"));
        president.add(new President("Niinistö, Sauli Väinämö", 2012, 2024, "Owner of Lennu, the First Dog"));

        lv = findViewById(R.id.presidentsListView);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MySingleton.getInstance().getPresidents()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "onItemClick(" + position + ")");
                Intent nextActivity = new Intent(MainActivity.this, PresidentDetailsActivity.class);
                nextActivity.putExtra("list", position);
                startActivity(nextActivity);
            }
        });

    }

}

