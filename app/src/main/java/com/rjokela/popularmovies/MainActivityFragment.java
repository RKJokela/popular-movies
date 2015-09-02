package com.rjokela.popularmovies;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public static final String TAG = MainActivityFragment.class.getSimpleName();

    private int screenWidth;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridView gridView = (GridView) getActivity().findViewById(R.id.main_gridview);
        screenWidth = gridView.getMeasuredWidth();
        gridView.setAdapter(new MovieAdapter());
    }

    private class MovieAdapter extends ArrayAdapter<String> {
        public MovieAdapter() {
            super(getActivity(), 0, new String[10]);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView view = new ImageView(getContext());

            view.setImageResource(position % 2 == 0 ? R.color.blue : R.color.white);
            view.setMinimumHeight(50);
            return view;
        }
    }
}
