package org.milaifontanals.navapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.milaifontanals.navapp.databinding.FragmentClientsBinding;
import org.milaifontanals.navapp.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClientsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientsFragment extends Fragment {

    public static final String ARG_YEAR = "year";
    private MainViewModel mViewmodel;
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
        mViewmodel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

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

        mViewmodel.setYear(mParamYear);
        mViewmodel.setDesc(mViewmodel.getHoroscopXines().get(mParamYear%12));
//        binding.txvYear.setText("ANY:"+mParamYear +"\n"+
//                                "HOROSCOP"+mViewmodel.getHoroscopXines().get(mParamYear%12));

        binding.btnBack.setOnClickListener(view -> {
            NavController nav = NavHostFragment.findNavController(this);
            nav.navigateUp();
        });

        binding.setViewmodel(mViewmodel);
        return binding.getRoot();
    }
}