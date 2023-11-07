package org.milaifontanals.a20221107_weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.milaifontanals.a20221107_weatherapp.model.WMOCodes;
import org.milaifontanals.a20221107_weatherapp.utils.NetworkUtils;
import org.w3c.dom.Text;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    public static final String TAG ="WEATHER_APP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Observable.fromCallable( ()-> {
            WMOCodes wmocode = new WMOCodes(this);
            Log.d(TAG, "Codi 0:\n"+wmocode.getDescription(0,true));
            Log.d(TAG, "Codi 55:\n"+wmocode.getDescription(55,true));
            String URL = "https://api.open-meteo.com/v1/forecast?latitude=41.581&longitude=1.6172&daily=weather_code,temperature_2m_max,temperature_2m_min,precipitation_sum";
            String json = NetworkUtils.getJSon(URL);
            Log.d(TAG, "Json descarregat:\n"+json);
            return json;
        } ).subscribeOn(Schedulers.io()).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe(
                    (json)->{
                        TextView txvJSON = findViewById(R.id.txvJSON);
                        txvJSON.setText(json);
                    }
        );


    }
}