package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Authentification extends AppCompatActivity {

    //final String pseudo_ = "narivo";
    //final String mot_de_passe_ = "narivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EditText mdp = findViewById(R.id.motDePasse);
       // EditText pseudo = findViewById(R.id.pseudo);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authentification);
        click_suivant();
    }


    public void click_suivant() {


        EditText mdp = findViewById(R.id.motDePasse);
        EditText pseudo = findViewById(R.id.pseudo);

        Button suivant = findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (pseudo.getText().toString().equals("narivo") && mdp.getText().toString().equals("narivo"))
                    {
                        Intent intent = new Intent(Authentification.this, Parametre.class);
                        startActivity(intent);
                    }
                else
                    {
                        String message_erreur = "une erreur survenue";
                        //int durre = Toast.LENGTH_SHORT;

                        Toast toast1 = Toast.makeText(Authentification.this, message_erreur,Toast.LENGTH_SHORT);
                        toast1.show();
                    }
            }
        });
    }
}
