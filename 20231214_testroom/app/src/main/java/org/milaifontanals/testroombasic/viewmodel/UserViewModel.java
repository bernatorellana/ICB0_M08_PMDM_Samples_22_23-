package org.milaifontanals.testroombasic.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.db.AppDatabase;
import org.milaifontanals.testroombasic.model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<User>> getUsers(){
        AppDatabase db = Room.databaseBuilder(getApplication(),
                        AppDatabase.class, "db_persones.db").build();

        UserDao userDao = db.userDao();
        return  userDao.getAll();
    }
}
