package com.example.systemesolaire;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView nomPlanete = findViewById(R.id.nomPlanete);
        TextView descriptionPlanete = findViewById(R.id.descriptionPlanete);
        TextView distance = findViewById(R.id.distance);
        TextView masse = findViewById(R.id.masse);
        TextView nbrSatelite = findViewById(R.id.nbrSatelite);
        TextView periode = findViewById(R.id.periode);


        // Récupérer les données de l'intent
        Planete planete = (Planete) getIntent().getSerializableExtra("PLANETE");

        if (planete != null) {
            imageView.setImageResource(planete.getImageId());
            nomPlanete.setText(planete.getNom());
            descriptionPlanete.setText(planete.getDescription());
            distance.setText(String.format("%.2f million Km", planete.getDistance()));
            masse.setText(String.valueOf(planete.getMasse()));
            nbrSatelite.setText(String.valueOf(planete.getNbrSatelite()));
            periode.setText(String.format("%.1f million d'annee", planete.getPeriode()));
        }
    }
}












