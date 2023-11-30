package org.milaifontanals.navapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.milaifontanals.navapp.R;
import org.milaifontanals.navapp.databinding.FragmentClientsBinding;
import org.milaifontanals.navapp.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientsFragment extends Fragment {

    public static final String ARG_YEAR = "year";

    private int mParamYear;
    public ClientsFragment() {
        // Required empty public constructor
    }


    public static ClientsFragment newInstance(int paramYear) {
        ClientsFragment fragment = new ClientsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_YEAR, paramYear);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamYear = getArguments().getInt(ARG_YEAR);
        }
    }
    private FragmentClientsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentClientsBinding.inflate(getLayoutInflater());

        binding.txvYear.setText("ANY:"+mParamYear);

        return binding.getRoot();
    }
}