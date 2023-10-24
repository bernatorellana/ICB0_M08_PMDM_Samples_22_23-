package org.milaifontanals.a20231024_acitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class DetallActivity extends AppCompatActivity {

    public static final String PARAM_NOM = "nom";
    public static final int RESULT_CODE_CANCEL = 1;
    public static final int RESULT_CODE_OK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall);

        Button btnDetall = findViewById(R.id.btnDetall);
        Button btnCancel = findViewById(R.id.btnCancel);
        EditText edtName = findViewById(R.id.edtName);

        // Recuperem el nom que m'estan passant
        // via l'Intente

        String nom =  getIntent().getStringExtra(PARAM_NOM);
        Log.d("TAG", "nom>"+nom);
        edtName.setText(nom);

        Persona p = (Persona) getIntent().getParcelableExtra("PERSONA");

        edtName.setText("PERSONA: "+p.getId()+":"+p.getNom());

        btnCancel.setOnClickListener(view -> {
            setResult(RESULT_CODE_CANCEL);
            finish();
        });

        btnDetall.setOnClickListener(view -> {
            String nom1 = ""+edtName.getText();
            Intent data = getIntent();
            data.putExtra(PARAM_NOM, nom1);
            setResult(RESULT_CODE_OK, data);
            finish();
        });

    }
}