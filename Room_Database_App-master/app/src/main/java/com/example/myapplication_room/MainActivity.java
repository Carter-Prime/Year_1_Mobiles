package com.example.myapplication_room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editBarcode, editName, editStock;
    Button deleteSpice, insertSpice;
    RecyclerView listSpice;
    RecyclerView.Adapter adapter;
    SpiceDao mySpiceDao;
    String barcode, name, stock;

    private View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.deleteSpices){
                barcode = editBarcode.getText().toString();
                Spice temp = mySpiceDao.getBarcode(barcode);
                if(temp == null){
                    return;
                }else {
                    delete(barcode);
                }
                updateUI();
            }else{
                barcode = editBarcode.getText().toString();
                name = editName.getText().toString();
                stock = editStock.getText().toString();
                insert(barcode, name, stock);
                updateUI();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editBarcode = findViewById(R.id.editBarcode);
        editName = findViewById(R.id.editSpiceName);
        editStock = findViewById(R.id.editStock);
        deleteSpice = findViewById(R.id.deleteSpices);
        insertSpice = findViewById(R.id.addSpice);
        listSpice = findViewById(R.id.rvSpiceList);

        Spice_Database mySpiceRackDb = Spice_Database.getINSTANCE(this);
        mySpiceDao = mySpiceRackDb.getSpiceDao();
        updateUI();
        deleteSpice.setOnClickListener(myClick);
        insertSpice.setOnClickListener(myClick);



        listSpice.setLayoutManager(new LinearLayoutManager(this));

    }

    public void insert(String barcode, String name, String stock){
        Spice spice = new Spice(barcode, name, stock);
        mySpiceDao.insertSpice(spice);
    }

    public void delete(String barcode){
        Spice toDelete = mySpiceDao.getBarcode(barcode);
        mySpiceDao.deleteSpice(toDelete);
    }

    public void updateUI(){
        List<Spice> spices = mySpiceDao.getAllSpices();
        adapter = new SpiceListAdapter(spices);
        listSpice.setAdapter(adapter);
    }

}
