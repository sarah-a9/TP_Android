package com.example.systemesolaire;

import java.io.Serializable;

public class Planete implements Serializable {
    private String nom;
    private String description;
    private float distance;
    private String masse;
    private float periode;
    private int nbrSatelite;
    private int imageId;

    public Planete(String nom, String description,float distance, String masse, float periode,int nbrSatelite , int imageId) {
        this.nom = nom;
        this.description = description;
        this.distance = distance;
        this.masse = masse;
        this.periode = periode;
        this.nbrSatelite = nbrSatelite;
        this.imageId = imageId;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    public float getDistance() {
        return distance;
    }

    public String getMasse() {
        return masse;
    }

    public float getPeriode() {
        return periode;
    }

    public int getNbrSatelite() {
        return nbrSatelite;
    }
}










