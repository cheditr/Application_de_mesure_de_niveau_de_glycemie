package com.example.mesuredeniveaudeglycmie.controller;

import com.example.mesuredeniveaudeglycmie.model.Patient;

public class Controller {
    private static Patient patient;
    public static Controller instance=null;
    private Controller()
    {
        super();
    }
    //Fleche userAction  view ---> constructor ---->moedl
    public static final Controller getInstance()
    {
        if(instance==null)
            instance=new Controller();
        return instance;
    }
    public void createPatient(int age,float valeurMesuree,boolean isFasting)
    {
        //Fleche update constructor ---> model
        patient=new Patient(age, valeurMesuree, isFasting);
    }
    //Fleche notify  constructor---->view
    public String getResult(){
        return patient.getResult();
    }
}
