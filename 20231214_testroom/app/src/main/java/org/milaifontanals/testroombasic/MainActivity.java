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
import android.widget.Button;

import org.milaifontanals.testroombasic.adapters.UsersAdapter;
import org.milaifontanals.testroombasic.dao.UserDao;
import org.milaifontanals.testroombasic.databinding.ActivityMainBinding;
import org.milaifontanals.testroombasic.db.AppDatabase;
import org.milaifontanals.testroombasic.model.User;
import org.milaifontanals.testroombasic.viewmodel.UserViewModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private UserViewModel viewModel;
    private UsersAdapter adapter;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rcyUsers.setLayoutManager(new LinearLayoutManager(this));




        //**************************************************
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        ConsultarUsaris();
        viewModel.insertFet.observe(this,insertFet -> {
            if (insertFet) {
                ConsultarUsaris();
            }
        } );
        binding.btnSave.setOnClickListener(view -> {
            viewModel.insert(binding.edtUid.getText()+"",
                    binding.edtFirstName.getText()+"",
                    binding.edtLastName.getText()+"");
        });
    }

    private void ConsultarUsaris() {
        LiveData<List<User>> users =  viewModel.getUsers();
        users.observe(this,elsUsuaris -> {
                Log.d("XXX", "usuaris:"+elsUsuaris);
                adapter = new UsersAdapter(elsUsuaris, this);
                binding.rcyUsers.setAdapter(adapter);
            }
        );
    }
}