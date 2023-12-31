package org.milaifontanals.a20221107_weatherapp.ViewModels;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.milaifontanals.a20221107_weatherapp.R;
import org.milaifontanals.a20221107_weatherapp.model.DailyWeather;
import org.milaifontanals.a20221107_weatherapp.model.WMOCodes;
import org.milaifontanals.a20221107_weatherapp.openweather.CityInfoResults;
import org.milaifontanals.a20221107_weatherapp.openweather.OpenWeatherAPI;
import org.milaifontanals.a20221107_weatherapp.utils.NetworkUtils;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends AndroidViewModel
{
    public MutableLiveData<List<DailyWeather>> getWeatherList() {
        return weatherList;
    }

    private MutableLiveData<List<DailyWeather>> weatherList = new MutableLiveData<>();
    public static final String TAG ="WEATHER_APP";

    /**
     * Constructor del ViewModel. Només es cridarà una vegada quan es crea
     * la MainActivity.
     * @param application
     */
    public MainActivityViewModel( Application application){
        super(application);

        Observable.fromCallable( ()-> {

             CityInfoResults r = OpenWeatherAPI.getCityInfo("Igualada");
             Log.d(TAG,r.toString());

            List<DailyWeather> wl = OpenWeatherAPI.getForecast7days(getApplication());
            weatherList.postValue(wl);
                    Log.d(TAG,weatherList.toString() );

                    return weatherList;
          } ).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe();
    }

}
