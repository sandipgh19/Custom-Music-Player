package com.cleveroad.audiowidget.example;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by sandip on 2/22/2017.
 */

public class MainFragment extends ListFragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.selection_items, android.R.layout.simple_list_item_1);
        //setListAdapter(adapter);
        //getListView().setOnItemClickListener(this);
       // AudioVisualizationFragment.newInstance();

                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.recycler_view, AudioVisualizationFragment.newInstance())
                                .addToBackStack(null)
                                .commit();
    }

   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            new AlertDialog.Builder(getContext())
                    .setTitle("Audio Visualization")
                    .setMessage("Open any music player and play your favorite songs. Audio Visualizer will detect sound and animate.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.recycler_view, AudioVisualizationFragment.newInstance())
                                    .addToBackStack(null)
                                    .commit();

                        }
                    })
                    .show();
        }
    }*/
}
