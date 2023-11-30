
package org.milaifontanals.a20221107_weatherapp.openweather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfoResults {

    @SerializedName("results")
    @Expose
    private List<CityInfo> results;
    @SerializedName("generationtime_ms")
    @Expose
    private Double generationtimeMs;

    public List<CityInfo> getResults() {
        return results;
    }

    public void setResults(List<CityInfo> results) {
        this.results = results;
    }

    public Double getGenerationtimeMs() {
        return generationtimeMs;
    }

    public void setGenerationtimeMs(Double generationtimeMs) {
        this.generationtimeMs = generationtimeMs;
    }

    @Override
    public String toString() {
        return "CityInfoResults{" +
                "results=" + results +
                '}';
    }
}
