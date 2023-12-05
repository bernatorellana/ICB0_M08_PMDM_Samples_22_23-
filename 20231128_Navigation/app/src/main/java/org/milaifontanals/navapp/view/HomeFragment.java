package org.milaifontanals.navapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.milaifontanals.navapp.R;
import org.milaifontanals.navapp.databinding.FragmentHomeBinding;
import org.milaifontanals.navapp.viewmodel.MainViewModel;


public class HomeFragment extends Fragment {

    MainViewModel mViewmodel;

    // RESPECT !
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mViewmodel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mViewmodel.getHoroscopXines().put(3, "EL CONEJO: Los que nacen en el Año del Conejo reúnen extraordinarias cualidades humanas: son prudentes, inteligentes, afables, discretos, previsores, atentos y benevolentes. Por eso, el signo del conejo es ampliamente aceptado por la gente.\n" +
                "\n" +
                "De carácter moderado e indulgente, amante de la paz y la concordia, el conejo odia la guerra y la violencia. Le gusta la vida tranquila, la ternura y la armonía.");
    }

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        binding.btnClients.setOnClickListener(view -> {

           NavDirections n = HomeFragmentDirections.actionHomeFragmentToClientsFragment(1203);

           NavController nav = NavHostFragment.findNavController(this);
           nav.navigate(n);
           /*Bundle bundle = new Bundle();
           bundle.putInt(ARG_YEAR, 2023);
           nav.navigate(R.id.action_homeFragment_to_clientsFragment,
                   bundle);*/
        });
        binding.btnProductes.setOnClickListener(view -> {
            NavController nav = NavHostFragment.findNavController(this);
            nav.navigate(R.id.action_homeFragment_to_productesFragment);
        });
        return binding.getRoot();

    }
}