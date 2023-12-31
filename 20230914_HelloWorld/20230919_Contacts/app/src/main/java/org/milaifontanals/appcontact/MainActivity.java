package org.milaifontanals.appcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SpinnerAdapter;

import org.milaifontanals.appcontact.databinding.ActivityMainBinding;
import org.milaifontanals.appcontact.model.Contact;
import org.milaifontanals.appcontact.model.Sexe;
import org.milaifontanals.appcontact.utils.TextChangedListener;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {


    private ArrayAdapter<String> adapterContactes;
    private static final String TAG = "AGENDA_CONTACTES";
    private ActivityMainBinding binding;



/*
    private EditText edtNewPhone;
    private ImageButton imbAdd;
*/
    private int indexContacte = 0;
    private int telefonIdSelected = -1; // -1 indica cap seleccionat

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
        programarEvents();

        OmplirSpinnerSexe();

        //*************************************************************

    }

    private void OmplirSpinnerSexe() {

        SpinnerAdapter adapter =
            new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                Sexe.values());// retorna tots els valors de l'enumeració
        binding.llyFitxaDades.spnSex.setAdapter(adapter);
    }

    private void programarEvents() {
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
        binding.llyEditorTelefons.imbAdd.setOnClickListener(view -> {
            Contact actual = Contact.getContactes().get(indexContacte);
            String nouTelefon = binding.llyEditorTelefons.edtNewPhone.getText().toString();
            boolean repetit = actual.getTelefons().contains(nouTelefon);
            if(!repetit) actual.getTelefons().add(nouTelefon);
            adapterContactes.notifyDataSetChanged();
            Log.d(TAG,"getSelectedItemPosition>"+ binding.llyEditorTelefons.lsvPhones.getSelectedItemPosition());
        });

        binding.llyEditorTelefons.imbDel.setOnClickListener(view -> {
            if(this.telefonIdSelected!=-1) {
                Contact actual = Contact.getContactes().get(indexContacte);
                // només eliminem la selecció quan esborrem l'últim telèfon
                boolean eliminarSeleccio = (actual.getTelefons().size()-1==this.telefonIdSelected);
                actual.getTelefons().remove(this.telefonIdSelected);
                adapterContactes.notifyDataSetChanged();
                if(eliminarSeleccio){
                    telefonIdSelected = -1;
                }
            }
        });

        binding.llyEditorTelefons.lsvPhones.setOnItemClickListener(
                (adapterView, view, position, id) -> {
                    telefonIdSelected = position;
        });


    }

    private void validaNom() {

        if(binding.llyFitxaDades.edtName.getText().toString().trim().length()<3){
            binding.llyFitxaDades.edtName.setError("Nom erroni");
        } else {
            binding.llyFitxaDades.edtName.setError(null);
        }
    }

    private void mostrarContacte(int index) {
        telefonIdSelected = -1;
        Contact c = Contact.getContactes().get(index);
        binding.llyFitxaDades.imvPhoto.setImageResource(c.getImatge());
        binding.llyFitxaDades.edtName.setText(c.getNom());
        binding.llyFitxaDades.edtEmail.setText(c.getEmail());

        binding.llyFitxaDades.spnSex.setSelection(c.getSexe().ordinal());

        binding.btnBack.setEnabled(index>0);
        binding.btnBack.setAlpha(binding.btnBack.isEnabled()?1: 0.25f);
        binding.btnForward.setEnabled(index<Contact.getContactes().size()-1);
        binding.btnForward.setAlpha(binding.btnForward.isEnabled()?1: 0.25f);

        // Gestió de la llista de telèfons
        adapterContactes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                                                c.getTelefons());
        binding.llyEditorTelefons.lsvPhones.setAdapter(adapterContactes);

        // Garantim que es es vegi la selecció.
        binding.llyEditorTelefons.lsvPhones.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        binding.llyEditorTelefons.lsvPhones.setSelector(R.color.dark_grey);
    }
}