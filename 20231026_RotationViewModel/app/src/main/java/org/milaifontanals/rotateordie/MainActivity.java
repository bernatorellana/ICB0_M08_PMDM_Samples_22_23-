package org.milaifontanals.rotateordie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import org.milaifontanals.rotateordie.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String SCORE_HOME = "SCORE_HOME";
    public static final String SCORE_VISITOR = "SCORE_VISITOR";
    public static final String SCORE_ARCHIVE = "SCORE_ARCHIVE";
    private ActivityMainBinding binding;

    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //viewModel = new MainActivityViewModel();// Facil....però ERRRRRRRRONI !!!!!


        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showScore();
        binding.btnHomeUp.setOnClickListener(view -> {
            viewModel.addScoreHome(+1);      showScore();});
        binding.btnVisitorUp.setOnClickListener(view -> {
            viewModel.addScoreVisitor(+1);   showScore();});
        binding.btnHomeUp.setOnLongClickListener(view -> {
            viewModel.addScoreHome(-1);     showScore();return true;});
        binding.btnVisitorUp.setOnLongClickListener(view -> {
            viewModel.addScoreVisitor(-1);  showScore();return true;});
    }



    private void showScore(){
        binding.txvScoreHome.setText(viewModel.getScoreHome()+"");
        binding.txvScoreVisitor.setText(viewModel.getScoreVisitor()+"");
    }
}