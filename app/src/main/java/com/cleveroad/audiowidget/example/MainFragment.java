package com.cleveroad.audiowidget.example;



import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

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



                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, AudioVisualizationFragment.newInstance())
                                .addToBackStack(null)
                                .commit();
    }
}
