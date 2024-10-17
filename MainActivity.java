package com.example.projet;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;
import java.util.stream.DoubleStream;

public class MainActivity extends AppCompatActivity {


    // TextView textView;
    //Button demmarrer ;//= (Button) findViewById(R.id.demmarrer);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        click_sur_demmarer();
        click_arreter();
        click_parametre ();
    }

    public void click_sur_demmarer(){
        Button demmarrer = findViewById(R.id.demmarrer);
        demmarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afficher_le_donnee();
            }
        });
    }
    public void click_arreter(){
        Button arreter = findViewById((R.id.arreter));
        arreter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textewiew = findViewById(R.id.temperature);
                textewiew.setText("FIN");
            }
        });
    }

    public void afficher_le_donnee() {
        FirebaseDatabase data = FirebaseDatabase.getInstance();
        DatabaseReference reference = data.getReference("temperature");

       ValueEventListener lire_donnee = new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               try {
                   Integer valeur = snapshot.getValue(Integer.class);
                   //int temperature = Integer.parseInt("67");
                   TextView textView = findViewById(R.id.temperature);
                   mise_jour_progresse(valeur);
                   textView.setText(String.valueOf(valeur));
               } catch (NumberFormatException e){
                   TextView textView = findViewById(R.id.temperature);
                   textView.setText("ERR");
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       };
       reference.addValueEventListener(lire_donnee);

    }

    //Random nombre = new Random();
    //int nombre_= nombre.nextInt(100);

    // mise_jour_progresse(donnee);
    //textView.setText(String.valueOf(donnee));


    public void mise_jour_progresse (int nombre_progress) {
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setProgress(nombre_progress);
    }

    public void click_parametre (){
        ImageButton parametre = findViewById(R.id.parametre);
        parametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Authentification.class);
                startActivity(intent);
            }
        });

    }

}


