package com.example.mesuredeniveaudeglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.example.mesuredeniveaudeglycmie.R;
import com.example.mesuredeniveaudeglycmie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private TextView tv_age, tvReponse;
    private EditText etValeur;
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private Button btnConsulter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Log.i("Information", "onProgressChange:" + progress);
                        tv_age.setText("Votre age :" + progress);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age;
                float valeurMesuree;
                boolean verifAge = false;
                boolean verifValeur = false;
                Log.i("information", "onClick sur le bouton consulter");
                if (sbAge.getProgress() != 0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veillez saisir votre age", Toast.LENGTH_SHORT).show();
                if (etValeur.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Veillez saisir la valeur", Toast.LENGTH_LONG).show();
                else
                    verifValeur = true;
                if (verifValeur && verifAge) {
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(etValeur.getText().toString());
                    //Fleche userAction  view ---> constructor ---->moedl
                    controller.createPatient(age,valeurMesuree,rbIsFasting.isChecked());
                    //Fleche notify  constructor---->view
                    tvReponse.setText(controller.getResult());
                    //calculer();
                }
            }
            });
    }
    private void init() {
        controller=Controller.getInstance();
        tv_age = findViewById(R.id.tv_age);
        tvReponse = findViewById(R.id.tvReponse);
        etValeur = findViewById(R.id.etValeur);
        sbAge = findViewById(R.id.sbAge);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnConsulter);
    }
}