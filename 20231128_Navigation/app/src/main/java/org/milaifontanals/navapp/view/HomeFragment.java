package org.milaifontanals.navapp.view;


import static org.milaifontanals.navapp.view.ClientsFragment.ARG_YEAR;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.milaifontanals.navapp.R;
import org.milaifontanals.navapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {


    // RESPECT !
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        binding.btnClients.setOnClickListener(view -> {

           NavController nav = NavHostFragment.findNavController(this);
           Bundle bundle = new Bundle();
           bundle.putInt(ARG_YEAR, 2023);
           nav.navigate(R.id.action_homeFragment_to_clientsFragment,
                   bundle);
        });
        binding.btnProductes.setOnClickListener(view -> {
            NavController nav = NavHostFragment.findNavController(this);
            nav.navigate(R.id.action_homeFragment_to_productesFragment);
        });
        return binding.getRoot();

    }
}