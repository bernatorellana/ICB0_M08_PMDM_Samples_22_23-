package org.milaifontanals.a20231024_acitivies;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Persona implements Parcelable {
    int id;
    String nom;

    public Persona(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    protected Persona(Parcel in) {
        id = in.readInt();
        nom = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    // =============== IMPLEMENTACIÓ PARCELABLE ======================
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nom);
    }


    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };


}
