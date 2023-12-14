package org.milaifontanals.testroombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import org.milaifontanals.testroombasic.adapters.UsersAdapter;
import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.db.AppDatabase;
import org.milaifontanals.testroombasic.model.User;
import org.milaifontanals.testroombasic.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserViewModel viewModel;
    private UsersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rcyUsers = findViewById(R.id.rcyUsers);
        rcyUsers.setLayoutManager(new LinearLayoutManager(this));

        //**************************************************
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        LiveData<List<User>> users =  viewModel.getUsers();
        users.observe(this,elsUsuaris -> {
                Log.d("XXX", "usuaris:"+elsUsuaris);
                adapter = new UsersAdapter(elsUsuaris, this);
                rcyUsers.setAdapter(adapter);
            }
        );
    }
}