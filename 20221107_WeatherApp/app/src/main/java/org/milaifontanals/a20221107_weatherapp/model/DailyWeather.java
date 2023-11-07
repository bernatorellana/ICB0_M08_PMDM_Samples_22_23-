package org.milaifontanals.a20221107_weatherapp.model;

import java.util.Date;

public class DailyWeather {
    float tempMax;
    float tempMin;
    float precipitationMm;
    String  weatherDescription;
    String  weatherImage;
    Date date;

    public DailyWeather(float tempMax, float tempMin, float precipitationMm, String weatherDescription, String weatherImage, Date date) {
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.precipitationMm = precipitationMm;
        this.weatherDescription = weatherDescription;
        this.weatherImage = weatherImage;
        this.date = date;

    }

    @Override
    public String toString() {
        return "DailyWeather{" +
                "tempMax=" + tempMax +
                ", tempMin=" + tempMin +
                ", precipitationMm=" + precipitationMm +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", weatherImage='" + weatherImage + '\'' +
                ", date=" + date +
                '}';
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getPrecipitationMm() {
        return precipitationMm;
    }

    public void setPrecipitationMm(float precipitationMm) {
        this.precipitationMm = precipitationMm;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(String weatherImage) {
        this.weatherImage = weatherImage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
