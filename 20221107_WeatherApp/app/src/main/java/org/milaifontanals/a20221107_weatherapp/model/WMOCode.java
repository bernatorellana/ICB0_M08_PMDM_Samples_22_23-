package org.milaifontanals.a20221107_weatherapp.model;



public class WMOCode {
    private String descDay;
    private String imageDay;
    private String descNight;
    private String imageNight;

    public WMOCode(String descDay, String imageDay, String descNight, String imageNight) {
        this.descDay = descDay;
        this.imageDay = imageDay;
        this.descNight = descNight;
        this.imageNight = imageNight;
    }

    public String getDescDay() {
        return descDay;
    }

    public void setDescDay(String descDay) {
        this.descDay = descDay;
    }

    public String getImageDay() {
        return imageDay;
    }

    public void setImageDay(String imageDay) {
        this.imageDay = imageDay;
    }

    public String getDescNight() {
        return descNight;
    }

    public void setDescNight(String descNight) {
        this.descNight = descNight;
    }

    public String getImageNight() {
        return imageNight;
    }

    public void setImageNight(String imageNight) {
        this.imageNight = imageNight;
    }
}
