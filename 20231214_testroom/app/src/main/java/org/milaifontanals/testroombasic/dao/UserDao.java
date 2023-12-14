package org.milaifontanals.testroombasic.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import org.milaifontanals.testroombasic.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    public void insertAll(User... users);

    @Update
    void update(User u);

    @Delete
    void delete(User user);
}
