package org.milaifontanals.testroombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.db.AppDatabase;
import org.milaifontanals.testroombasic.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //**************************************************
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db_persones.db").
                allowMainThreadQueries().build();
        // ATENCIÓ: allowMainThreadQueries() ÉS UNA XAPU, i només
        //           es fa servir per proposits demostratius !



        UserDao userDao = db.userDao();
        /*User u1 = new User(12,"Pep", "González");
        User u2 = new User(5,"Cristina", "Pérez");
        userDao.insertAll(u1,u2);*/

        List<User> usuaris = userDao.getAll();
        for(User u:usuaris){
            Log.d("XXX", u.toString());
            u.firstName = "Mr."+u.firstName;
            userDao.update(u);
        }

    }
}