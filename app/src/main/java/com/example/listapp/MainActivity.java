package com.example.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gets resources to use in the application's main activity, initializes them

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter ItemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(ItemAdapter);
        // adapter merges the list, with the layout and the array
        // <type of data> (this, layout, array)

        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.listapp.ITEM_INDEX", i);
                startActivity(showDetailActivity);

            }
        });


    }
}
