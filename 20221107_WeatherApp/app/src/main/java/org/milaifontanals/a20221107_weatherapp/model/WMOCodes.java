package org.milaifontanals.a20221107_weatherapp.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;
import org.milaifontanals.a20221107_weatherapp.MainActivity;
import org.milaifontanals.a20221107_weatherapp.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class WMOCodes {

    private HashMap<Integer,WMOCode> codeMapping;
    public WMOCodes(Context c) throws Exception {
        InputStream is =  c.getResources().openRawResource(R.raw.wmo_database);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String json="", line;
        while((line = br.readLine()) != null){
            json+=line;
        }
        Log.d(MainActivity.TAG, "WMO JSON:"+json);
        JSONObject arrel = new JSONObject(json);
        Iterator<String> it = arrel.keys();
        codeMapping = new HashMap<>();
        while(it.hasNext()){
            String codi = it.next();
            JSONObject arrelCodi = arrel.getJSONObject(codi);
            JSONObject day = arrelCodi.getJSONObject("day");
            String dayDesc = day.getString("description");
            String dayImage = day.getString("image");
            JSONObject night = arrelCodi.getJSONObject("night");
            String nightDesc = night.getString("description");
            String nightImage = night.getString("image");
            WMOCode code = new WMOCode(dayDesc,dayImage,nightDesc, nightImage);
            codeMapping.put( Integer.parseInt(codi) , code);
        }
    }

    public String getDescription(int codi, boolean isDay) {
        WMOCode code = codeMapping.get(codi);
        if(isDay){
            return code.getDescDay();
        } else
            return code.getDescNight();
    }
}
