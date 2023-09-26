package org.milaifontanals.appcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.milaifontanals.appcontact.databinding.ActivityMainBinding;
import org.milaifontanals.appcontact.model.Contact;
import org.milaifontanals.appcontact.utils.TextChangedListener;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "AGENDA_CONTACTES";
    private ActivityMainBinding binding;
/*
    private EditText edtNewPhone;
    private ImageButton imbAdd;
*/
    int indexContacte = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mostrarContacte(indexContacte);
        //******************************************************************
        // Programació d'events
        //******************************************************************
        // Programar els botons
        binding.btnForward.setOnClickListener( c -> {
            // Codi que s'executa quan fas click sobre el botó forward
            //indexContacte  =(indexContacte+1)%Contact.getContactes().size();
            if(indexContacte<Contact.getContactes().size()-1){
                indexContacte++;
            }
            mostrarContacte(indexContacte);
        });

        binding.btnBack.setOnClickListener( c -> {
            // Codi que s'executa quan fas click sobre el botó back
            if(indexContacte>0){
                indexContacte--;
            }
            mostrarContacte(indexContacte);
        });
        // Programar els textchanged
        binding.llyFitxaDades.edtName.addTextChangedListener(new TextChangedListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                validaNom();
                Log.d(TAG, "estic passant pel textChanged"+binding.llyFitxaDades.edtName.getText());
                Contact actual = Contact.getContactes().get(indexContacte);
                actual.setNom(binding.llyFitxaDades.edtName.getText().toString());
            }
        });


        binding.llyFitxaDades.edtEmail.addTextChangedListener(new TextChangedListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                Contact actual = Contact.getContactes().get(indexContacte);
                actual.setEmail(binding.llyFitxaDades.edtEmail.getText().toString());
            }
        });


        //*************************************************************

    }

    private void validaNom() {

        if(binding.llyFitxaDades.edtName.getText().toString().trim().length()<3){
            binding.llyFitxaDades.edtName.setError("Nom erroni");
        } else {
            binding.llyFitxaDades.edtName.setError(null);
        }
    }

    private void mostrarContacte(int index) {
        Contact c = Contact.getContactes().get(index);
        binding.llyFitxaDades.imvPhoto.setImageResource(c.getImatge());
        binding.llyFitxaDades.edtName.setText(c.getNom());
        binding.llyFitxaDades.edtEmail.setText(c.getEmail());

        binding.btnBack.setEnabled(index>0);
        binding.btnBack.setAlpha(binding.btnBack.isEnabled()?1: 0.25f);
        binding.btnForward.setEnabled(index<Contact.getContactes().size()-1);
        binding.btnForward.setAlpha(binding.btnForward.isEnabled()?1: 0.25f);

    }
}