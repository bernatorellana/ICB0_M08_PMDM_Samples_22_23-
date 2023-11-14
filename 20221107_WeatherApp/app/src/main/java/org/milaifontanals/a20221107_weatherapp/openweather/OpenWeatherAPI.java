package org.milaifontanals.a20221107_weatherapp.openweather;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.milaifontanals.a20221107_weatherapp.MainActivity;
import org.milaifontanals.a20221107_weatherapp.model.DailyWeather;
import org.milaifontanals.a20221107_weatherapp.model.WMOCodes;
import org.milaifontanals.a20221107_weatherapp.utils.NetworkUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenWeatherAPI {

    public static final String TAG ="WEATHER_APP";

    public static List<DailyWeather> getForecast7days(Context c){
        List<DailyWeather> weatherList = new ArrayList<>();
        try {
            WMOCodes wmocode = new WMOCodes(c);
            Log.d(TAG, "Codi 0:\n"+wmocode.getDescription(0,true));
            Log.d(TAG, "Codi 55:\n"+wmocode.getDescription(55,true));
            String URL = "https://api.open-meteo.com/v1/forecast?latitude=41.581&longitude=1.6172&daily=weather_code,temperature_2m_max,temperature_2m_min,precipitation_sum";
            String json = NetworkUtils.getJSon(URL);
            Log.d(TAG, "Json descarregat:\n"+json);

            WMOCodes wmo = new WMOCodes(c);

            JSONObject arrel = new JSONObject(json);
            JSONObject daily = arrel.getJSONObject("daily");
            JSONArray time = daily.getJSONArray("time");
            JSONArray weather_code = daily.getJSONArray("weather_code");
            JSONArray temperature_2m_max = daily.getJSONArray("temperature_2m_max");
            JSONArray temperature_2m_min = daily.getJSONArray("temperature_2m_min");
            JSONArray precipitation_sum = daily.getJSONArray("precipitation_sum");


            for (int i = 0; i < time.length(); i++) {
                // ---------- data de la mesura ---------------
                String dS = time.getString(i);//"2023-11-09",
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sdf.parse(dS);
                //---------------- codi WMO ---------------------
                int wc = weather_code.getInt(i);
                String desc = wmo.getDescription(wc, true);
                String imatgeUrl = wmo.getImage(wc, true);
                //-------------------------------------
                float tmax = (float) temperature_2m_max.getDouble(i);
                float tmin = (float) temperature_2m_min.getDouble(i);
                float prec = (float) precipitation_sum.getDouble(i);

                DailyWeather dw = new DailyWeather(tmax, tmin, prec, desc, imatgeUrl, d);
                weatherList.add(dw);
            }

        } catch(Exception ex) {
            Log.e(MainActivity.TAG, "Error parsejant JSON getForecast7days", ex);
        }
        return weatherList;
    }
}
