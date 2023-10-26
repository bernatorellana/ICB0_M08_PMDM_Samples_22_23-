package org.milaifontanals.rotateordie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

    private int scoreHome=0, scoreVisitor=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            // Estem ressucitant qual ave Fenix
            this.scoreHome      = savedInstanceState.getInt(SCORE_HOME);
            this.scoreVisitor   = savedInstanceState.getInt(SCORE_VISITOR);
        } else {
            SharedPreferences pref = getSharedPreferences(SCORE_ARCHIVE, Context.MODE_PRIVATE);
            this.scoreHome = pref.getInt(SCORE_HOME,0);
            this.scoreVisitor = pref.getInt(SCORE_VISITOR,0);
        }
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showScore();
        binding.btnHomeUp.setOnClickListener(view -> {scoreHome++;showScore();});
        binding.btnVisitorUp.setOnClickListener(view -> {scoreVisitor++;showScore();});
        binding.btnHomeUp.setOnLongClickListener(view -> {scoreHome--;showScore();return true;});
        binding.btnVisitorUp.setOnLongClickListener(view -> {scoreVisitor--;showScore();return true;});


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // Desem les dades abans de morir (RIP)
        outState.putInt(SCORE_HOME,scoreHome);
        outState.putInt(SCORE_VISITOR,scoreVisitor);
        // Fem persistència de les dades
        SharedPreferences pref = getSharedPreferences(SCORE_ARCHIVE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  pref.edit();
        editor.putInt(SCORE_HOME,scoreHome);
        editor.putInt(SCORE_VISITOR,scoreVisitor);
        editor.commit();

        super.onSaveInstanceState(outState);
    }

    private void showScore(){
        binding.txvScoreHome.setText(scoreHome+"");
        binding.txvScoreVisitor.setText(scoreVisitor+"");
    }
}