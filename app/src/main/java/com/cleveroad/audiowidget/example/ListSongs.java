package com.cleveroad.audiowidget.example;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sandip on 2/24/2017.
 */

public class ListSongs extends ListActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    private static final int MUSIC_LOADER_ID = 1;
    private static final int OVERLAY_PERMISSION_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.playlist);

        String[] adobe_products = getResources().getStringArray(R.array.adobe_products);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.playlist_item, R.id.songTitle, adobe_products));

        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int songIndex = position;
                Intent in = new Intent(getApplicationContext(),AndroidBuildingMusicPlayerActivity.class);
                // Sending songIndex to PlayerActivity
                in.putExtra("songIndex", songIndex);
                //setResult(100, in);

              /*  if (!isServiceRunning(MusicService.class)) {
                    MusicService.setTracks(ListSongs.this, songIndex);
                }
                MusicService.playTrack(ListSongs.this, songIndex);
                //startActivity(in);*/

            }
        });
    }

    private void onPermissionsNotGranted() {
        Toast.makeText(this, R.string.toast_permissions_not_granted, Toast.LENGTH_SHORT).show();
        finish();
    }

    private boolean isServiceRunning(@NonNull Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
