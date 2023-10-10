package org.milaifontanals.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.milaifontanals.recyclerviewapp.adapters.CardsAdapter;

public class MainActivity extends AppCompatActivity {

    private CardsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();


        // 0.- Busquem el RecyclerView
        RecyclerView rcyCards = findViewById(R.id.rcyCards);
        // 1.- Configurem el RecyclerView ( direcció )
        rcyCards.setLayoutManager(
                new LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false)
        );
        rcyCards.setHasFixedSize(true); // només en el cas que les files tinguin la mateixa alçada
        // 2.- Crear l'adapter
        adapter = new CardsAdapter(this, Card.getCartes());

        // 3.- Connectar l'adapter al Recycler View
        rcyCards.setAdapter(adapter);
    }

    private void setupActionBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

       // Línia màgica per esborrar el títol de l'aplicació
        getSupportActionBar().setDisplayShowTitleEnabled(false);
       //myToolbar.displa(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //menu.getItem(0).setEnabled(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_delete) {
            adapter.deleteSelected();
            return true;

        } if(id==R.id.action_down) {
               adapter.move(+1);
                return true;
        } if(id==R.id.action_up) {
            adapter.move(-1);
            return true;
        } else {
                // The user's action isn't recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

}