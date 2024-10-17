package com.example.projet;

import android.annotation.SuppressLint;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Email {

    private Integer valeur;
    private Boolean envoyer;
    private  DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public Email(Integer valeur, Boolean envoyer){
        this.valeur = valeur;
        this.envoyer = envoyer;
    }

    public void envoyer_donnee (Integer valeur_, boolean envoyer_){
        //Email donnee = new Email(valeur_, envoyer_);
        //String valeur_string=valeur.toString();

        mDatabase.child("valeur").setValue(envoyer_);
        mDatabase.child("envoyer").setValue(valeur_);

    }
}
