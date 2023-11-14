package org.milaifontanals.a20221107_weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import org.milaifontanals.a20221107_weatherapp.ViewModels.MainActivityViewModel;
import org.milaifontanals.a20221107_weatherapp.model.DailyWeather;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String TAG ="WEATHER_APP";
    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getWeatherList().observe(this,dailyWeathers -> {
            TextView t = findViewById(R.id.txvJSON);
            t.setText(dailyWeathers.toString());
        });

    }
}