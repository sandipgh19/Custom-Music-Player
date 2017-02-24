package com.cleveroad.audiowidget.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sandip on 2/24/2017.
 */

public class ListSongs extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        listView=(ListView)findViewById(R.id.list);

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Song 1"));
        dataModels.add(new DataModel("Song 2"));
        dataModels.add(new DataModel("Song 3"));
        dataModels.add(new DataModel("Song 4"));
        dataModels.add(new DataModel("Song 5"));


        adapter= new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);
                int songIndex = position;
                Intent in = new Intent(getApplicationContext(),
                        AndroidBuildingMusicPlayerActivity.class);
                // Sending songIndex to PlayerActivity
                in.putExtra("songIndex", songIndex);
                setResult(100, in);

            }
        });
    }
}
