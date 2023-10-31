package org.milaifontanals.rotateordie;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivityViewModel extends ViewModel {

    private int scoreHome=0;
    private int scoreVisitor=0;

    private Date horaInicial;
    private MutableLiveData<Date> horaActual = new MutableLiveData<>();

    public MainActivityViewModel(){
        horaInicial = new Date();
        horaActual.setValue(horaInicial);
        programarTimer();

    }

    private void programarTimer() {

       Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                long milisegons = (new Date()).getTime() - horaInicial.getTime();
                Date diff = new Date(milisegons);
                horaActual.postValue(diff);
            }
        },0,1000);
    }


    public MutableLiveData<Date> getHoraActual() {
        return horaActual;
    }

    public int getScoreHome() {
        return scoreHome;
    }


    public void addScoreHome(int delta) {
        this.scoreHome += delta;
    }

    public void addScoreVisitor(int delta) {
        this.scoreVisitor += delta;
    }


    public void setScoreHome(int scoreHome) {
        this.scoreHome = scoreHome;
    }

    public int getScoreVisitor() {
        return scoreVisitor;
    }

    public void setScoreVisitor(int scoreVisitor) {
        this.scoreVisitor = scoreVisitor;
    }
}
