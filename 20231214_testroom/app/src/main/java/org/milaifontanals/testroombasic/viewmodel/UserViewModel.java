package org.milaifontanals.testroombasic.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.db.AppDatabase;
import org.milaifontanals.testroombasic.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserViewModel extends AndroidViewModel {
    private AppDatabase db;

    public MutableLiveData<Boolean> insertFet = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application,
                AppDatabase.class, "db_persones.db").build();
        insertFet.setValue(false);
    }

    public LiveData<List<User>> getUsers(){
        UserDao userDao = db.userDao();
        return  userDao.getAll();
    }

    public void insert(String id, String firstName, String lastName) {

        Observable.fromCallable(() -> {
            Log.d("XXX", "Inserim ????");
            UserDao userDao = db.userDao();
            User u = new User(Integer.parseInt(id), firstName, lastName);
            userDao.insertAll(u);
            insertFet.postValue(true);
            return true;
        }).subscribeOn(Schedulers.io()).subscribe();


    }


}
