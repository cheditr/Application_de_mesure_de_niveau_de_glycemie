package com.example.mesuredeniveaudeglycmie;

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

public class MainActivity extends AppCompatActivity {
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
                calculer();
            }
        });
    }

    private void init() {
        tv_age = findViewById(R.id.tv_age);
        tvReponse = findViewById(R.id.tvReponse);
        etValeur = findViewById(R.id.etValeur);
        sbAge = findViewById(R.id.sbAge);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnConsulter);

    }

    public void calculer() {
        Log.i("information", "onClick sur le bouton consulter");
        int age;
        float valeur;
        boolean verifAge = false, verifValeur = false;
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
            valeur = Float.valueOf(etValeur.getText().toString());
            if (rbIsFasting.isChecked()) {
                if (age >= 13) {
                    if (valeur < 5.0)
                        tvReponse.setText("Niveau de glycemie trop bas");
                    else if (valeur <= 7.2)
                        tvReponse.setText("Niveau de glycemie normal");
                    else
                        tvReponse.setText("Niveau de glycemie trop elevee");
                } else if (age >= 6) {
                    if (valeur < 5.0)
                        tvReponse.setText("Niveau de glycemie trop bas");
                    else if (valeur <= 10.0)
                        tvReponse.setText("Niveau de glycemie normal");
                    else
                        tvReponse.setText("Niveau de glycemie trop elevee");
                }else if (age < 6) {
                    if (valeur< 5.5)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeur >= 5.5 && valeur <= 10.0)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                }
                else {
                    if (valeur > 10.5)
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                    else
                        tvReponse.setText("Niveau de glycémie est normale");
                }
            }
        }
    }
}