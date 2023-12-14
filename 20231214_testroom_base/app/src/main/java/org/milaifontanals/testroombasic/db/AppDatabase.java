package org.milaifontanals.testroombasic.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
