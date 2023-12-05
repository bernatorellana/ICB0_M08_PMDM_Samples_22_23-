package org.milaifontanals.navapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.HashMap;

public class MainViewModel extends AndroidViewModel {
    private int year;
    private HashMap<Integer,String> horoscopXines = new HashMap<>();

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap<Integer, String> getHoroscopXines() {
        return horoscopXines;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear(){
        return year;
    }


    public MainViewModel(@NonNull Application application) {
        super(application);
        horoscopXines.put(0, "RATA: Los nacidos bajo el signo de la Rata son persona sabias a las que les gusta rodearse de familiares y amigos, a quienes ayudan en sus quehaceres y problemas diarios. Buenas trabajadoras, ahorradores y buenos administradores de su economía.");
        horoscopXines.put(1, "TIGRE: Los búfalos o bueyes son animales pacientes y tranquilos, que irradian mucho cariño y amor e infunden respeto. Grandes trabajadores, se sienten a gusto rodeados del orden y la limpieza y logran el éxito gracias a su esfuerzo. Para ellos lo más importante es la familia, aunque son celosos con su pareja. Aman el arte y la música. No les gusta discutir, aunque sí que le obedezcan.");
        horoscopXines.put(2, "BUEY: as personas de este signo son muy pasionales y llenas de energía. No pasan desapercibidas, son aventureros, independientes, ingeniosos, impulsivos y les gusta la diversión. Son amigos para toda la vida, aunque les gusta ser el líder del grupo. En el mundo de las relaciones de pareja se muestran el más fuerte, sexy y seductor, aunque de comportamiento excesivo.");

    }




}
