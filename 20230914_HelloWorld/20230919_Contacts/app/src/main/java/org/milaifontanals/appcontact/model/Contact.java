package org.milaifontanals.appcontact.model;

import androidx.annotation.DrawableRes;

import org.milaifontanals.appcontact.R;

import java.util.ArrayList;

public class Contact {


    // Mètode per accedir a la llista global de contactes
    // (singleton)
    private static ArrayList<Contact> _contactes;

    public static ArrayList<Contact> getContactes(){
        if(_contactes==null){
            _contactes = new ArrayList<>();
            Contact c1 = new Contact(R.drawable.witcher, "The witcher",
                    Sexe.HOME,
                    "thewitcher@greetingsfromhell.com",
                    "+34 6236363");
            c1.getTelefons().add("654123234");
            c1.getTelefons().add("674372382");
            _contactes.add(c1);
            Contact c2 = new Contact(R.drawable.yennefer, "Yenneffer",
                    Sexe.DONA,
                    "yenneferf@greetingsfromhell.com",
                    "+34 62343453");
            _contactes.add(c2);
            Contact c3 = new Contact(R.drawable.ciri, "Ciri",
                    Sexe.DONA,
                    "ciri@greetingsfromhell.com",
                    "+34 543654654");
            _contactes.add(c3);
            c3.getTelefons().add("654562323");
            Contact c4 = new Contact(R.drawable.dijkstra, "Dijkstra",
                    Sexe.HOME,
                    "dijkstra@greetingsfromhell.com",
                    "+34 523234634");
            _contactes.add(c4);
            Contact c5 = new Contact(R.drawable.bard, "Dandelion",
                    Sexe.HOME,
                    "Dandelion@greetingsfromhell.com",
                    "+34 345234765");
            _contactes.add(c5);


        }
        return _contactes;
    }

    @DrawableRes
    private int imatge;
    private String nom;
    private Sexe sexe;
    private String email;
    private ArrayList<String> telefons;

    public Contact(@DrawableRes int imatge,
                   String nom,
                   Sexe sexe,
                   String email,
                   String telefon) {
        this.imatge = imatge;
        this.nom = nom;
        this.sexe = sexe;
        this.email = email;
        telefons = new ArrayList<>();
        telefons.add(telefon);
    }

    public int getImatge() {
        return imatge;
    }

    public void setImatge(int imatge) {
        this.imatge = imatge;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getTelefons() {
        return telefons;
    }

}
