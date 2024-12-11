package com.example.systemesolaire;


import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaneteAdapter adapter;
    private List<Planete> planeteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ajouter des données pour les planètes
        planeteList = new ArrayList<>();
        planeteList.add(new Planete("Mercure", "Première planète du système solaire.",52.662F,"3.285 × 10^23 kg",88F,0, R.drawable.mercure));
        planeteList.add(new Planete("Vénus", "Deuxième planète, très chaude.", 108.77F,"4.867 × 10^24 kg",117,0,R.drawable.venus));
        planeteList.add(new Planete("Terre", "Notre planète.", 147.68F,"5.97219 × 10^24 kilograms",365.25F,1,R.drawable.terre));
        planeteList.add(new Planete("Mars", "La planète rouge.", 236.62F,"6.39 × 10^23 kg",687F,2,R.drawable.mars));
        planeteList.add(new Planete("Jupiter", "La plus grande planète.", 758.15F,"1.898 × 10^27 kg",4380F,95,R.drawable.jupiter));
        planeteList.add(new Planete("Saturne", "Connue pour ses anneaux.", 14415.00F,"5.683 × 10^26 kg",10731F,146,R.drawable.saturne));
        planeteList.add(new Planete("Uranus", "Une géante gazeuse glacée.", 29249.00F,"8.681 × 10^25 kg",30660F,27,R.drawable.uranus));
        planeteList.add(new Planete("Neptune", "La planète la plus éloignée.", 44715.00F,"1.024 × 10^26 kg",601520,14,R.drawable.neptune));

        //Log.d("MainActivity", "Planets List Size: " + planeteList.size());  // Check if all planets are added


        adapter = new PlaneteAdapter(this, planeteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}