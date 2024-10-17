package com.example.projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Parametre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parametre);

        //envoyer_de_mail();

        click_envoyer();
    }

    public void click_envoyer(/*Integer valeur, boolean envoyer*/) {
        Button envoyer_button = findViewById(R.id.envoyer_email);
        //Email donnee = new Email(valeur,envoyer);
        envoyer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                envoyer_de_mail();
                //donnee.envoyer_donnee(valeur,envoyer);
                /**Intent intent = new Intent(Parametre.this, MainActivity.class);
                 startActivity(intent);*/
            }
        });
    }


    public void envoyer_de_mail() {

        EditText valeur_temperature = findViewById(R.id.valeur);
        String valeur_temperature_string = valeur_temperature.getText().toString();
        CheckBox chexck_email = findViewById(R.id.checkbox_email);


        chexck_email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //envoyer l'email

                Integer valeur_temperature_int = Integer.parseInt(valeur_temperature_string);
                Email donnee = new Email(valeur_temperature_int, true);

                if (chexck_email.isChecked()) {

                    if (valeur_temperature.getText() != null) {

                        //click_envoyer(Integer.valueOf(valeur_temperature_int),true);
                        donnee.envoyer_donnee(valeur_temperature_int, true);

                    } else {
                        TextView alerte = findViewById(R.id.alerte);
                        alerte.setText("Entrer une valeur numerique");

                    }
                    //}else{

              /*      donnee.envoyer_donnee(valeur_,true);

                    String message = "Vous n'avez pas cocher l'email";
                    Integer durre = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(Parametre.this,message,durre);
                    toast.show();
                    /**texteee***/
                } else {
                    chexck_email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            //envoyer l'email
                            //CheckBox chexck_email = findViewById(R.id.checkbox_email);
                            Integer valeur_temperature_int = Integer.parseInt(valeur_temperature_string);
                            Email donnee = new Email(valeur_temperature_int, false);
                            //Email donnee = new Email(valeur_, chexck_email.isChecked());
                            //if (chexck_email.isChecked() ) {


                            if (valeur_temperature.getText() != null) {

                                //click_envoyer(Integer.valueOf(valeur_temperature_int),false);
                                donnee.envoyer_donnee(valeur_temperature_int, false);

                            } else {
                                TextView alerte = findViewById(R.id.alerte);
                                alerte.setText("Entrer une valeur numerique");

                            }

                        }

                    });

                }
            }

        });
    }
}




    /*

    public Boolean checkBox (){
        CheckBox checkBox = findViewById(R.id.checkbox_email);
        if (checkBox.isChecked()){
            return true;
        }else {
            return false;
        }
    }

   /* public void envoyer_sur_firebase(EditText valeur_temperature,CheckBox chexck_email) {
        //EditText valeur_temperature = findViewById(R.id.valeur);
        String valeur_temperature_string = valeur_temperature.getText().toString();
        Integer valeur_temperature_int = Integer.parseInt(valeur_temperature_string);
        //CheckBox chexck_email = findViewById(R.id.checkbox_email);

        if (chexck_email.isChecked()) {
            chexck_email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (valeur_temperature.getText()!=null){
                        click_envoyer(valeur_temperature_int,true);
                    } else{
                        TextView alerte = findViewById(R.id.alerte);
                        alerte.setText("Entrer une valeur numerique");
                    }
                }
            });

        }else{
            chexck_email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (valeur_temperature.getText()!=null){
                        click_envoyer(valeur_temperature_int,false);
                    } else{
                        TextView alerte = findViewById(R.id.alerte);
                        alerte.setText("Entrer une valeur numerique");
                    }
                }
            });

        }
    }*/


