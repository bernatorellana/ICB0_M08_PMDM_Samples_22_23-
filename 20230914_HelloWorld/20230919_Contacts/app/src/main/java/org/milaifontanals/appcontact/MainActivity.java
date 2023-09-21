package org.milaifontanals.appcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.milaifontanals.appcontact.databinding.ActivityMainBinding;
import org.milaifontanals.appcontact.model.Contact;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
/*
    private EditText edtNewPhone;
    private ImageButton imbAdd;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mostrarContacte(Contact.getContactes().get(1));

    }

    private void mostrarContacte(Contact c) {
        binding.llyFitxaDades.imvPhoto.setImageResource(c.getImatge());
        binding.llyFitxaDades.edtName.setText(c.getNom());
        binding.llyFitxaDades.edtEmail.setText(c.getEmail());
    }
}