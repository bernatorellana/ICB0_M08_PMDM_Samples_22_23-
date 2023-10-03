package org.milaifontanals.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.milaifontanals.recyclerviewapp.adapters.CardsAdapter;

public class MainActivity extends AppCompatActivity {

    private CardsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        adapter = new CardsAdapter(Card.getCartes());

        // 3.- Connectar l'adapter al Recycler View
        rcyCards.setAdapter(adapter);
    }
}