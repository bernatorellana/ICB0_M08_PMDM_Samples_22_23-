package org.milaifontanals.navapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.milaifontanals.navapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductesFragment extends Fragment {

    public ProductesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_productes, container, false);
    }
}