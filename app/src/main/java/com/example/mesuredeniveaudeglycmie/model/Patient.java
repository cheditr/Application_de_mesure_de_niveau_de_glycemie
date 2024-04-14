package com.example.mesuredeniveaudeglycmie.model;

import android.util.Log;
import android.widget.Toast;

import com.example.mesuredeniveaudeglycmie.view.MainActivity;

public class Patient {
    private int age;
    private float valeurMesuree;
    private boolean isFasting;
    private String result;
    //Fleche update constructor ---> model
    public Patient(int age, float valeurMesuree, boolean isFasting) {
        this.age = age;
        this.valeurMesuree = valeurMesuree;
        this.isFasting = isFasting;
        setResult();
    }
    public void setResult() {
            if (isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        result="Niveau de glycemie trop bas";
                    else if (valeurMesuree <= 7.2)
                        result="Niveau de glycemie normal";
                    else
                        result="Niveau de glycemie trop elevee";
                } else if (age >= 6) {
                    if (valeurMesuree < 5.0)
                        result="Niveau de glycemie trop bas";
                    else if (valeurMesuree <= 10.0)
                        result="Niveau de glycemie normal";
                    else
                        result="Niveau de glycemie trop elevee";
                }else if (age < 6) {
                    if (valeurMesuree< 5.5)
                        result="Niveau de glycémie est trop bas";
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        result="Niveau de glycémie est normale";
                    else
                        result="Niveau de glycémie est trop élevé";
                }
                else {
                    if (valeurMesuree > 10.5)
                        result="Niveau de glycémie est trop élevé";
                    else
                        result="Niveau de glycémie est normale";
                }
            }
        }
     //Fleche notify  model ---> constructor
    public String getResult() {
        return result;
    }
}
