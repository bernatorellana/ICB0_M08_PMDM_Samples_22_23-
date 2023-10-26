package org.milaifontanals.rotateordie;

import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private int scoreHome=0;
    private int scoreVisitor=0;

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
