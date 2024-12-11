package com.example.recyclerviews;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<JeuVideo> mesJeux;
    private MyVideoGamesAdapter monAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);

        mesJeux = new ArrayList<>();

        mesJeux.add(new JeuVideo("Barbie", 50.0F));
        mesJeux.add(new JeuVideo("Skims", 150.0F));
        mesJeux.add(new JeuVideo("GTA V", 250.0F));
        mesJeux.add(new JeuVideo("Fortnite", 80.99F));
        mesJeux.add(new JeuVideo("The Legend of Zelda: Breath of the Wild", 299.99F));
        mesJeux.add(new JeuVideo("Minecraft", 26.95F));
        mesJeux.add(new JeuVideo("Call of Duty: Modern Warfare II", 59.99F));
        mesJeux.add(new JeuVideo("Red Dead Redemption 2", 49.99F));
        mesJeux.add(new JeuVideo("Horizon Forbidden West", 69.99F));
        mesJeux.add(new JeuVideo("FIFA 23", 59.99F));
        mesJeux.add(new JeuVideo("Elden Ring", 59.99F));
        mesJeux.add(new JeuVideo("Super Mario Odyssey", 49.99F));
        mesJeux.add(new JeuVideo("Cyberpunk 2077", 29.99F));
        mesJeux.add(new JeuVideo("God of War: Ragnarök", 69.99F));
        mesJeux.add(new JeuVideo("Animal Crossing: New Horizons", 59.99F));
        mesJeux.add(new JeuVideo("Overwatch 2", 39.99F));
        mesJeux.add(new JeuVideo("The Sims 4", 19.99F));
        mesJeux.add(new JeuVideo("Among Us", 4.99F));
        mesJeux.add(new JeuVideo("League of Legends", 50.0F));
        mesJeux.add(new JeuVideo("PUBG: Battlegrounds", 29.99F));
        mesJeux.add(new JeuVideo("The Witcher 3: Wild Hunt", 39.99F));
        mesJeux.add(new JeuVideo("Assassin's Creed Valhalla", 59.99F));
        mesJeux.add(new JeuVideo("Mario Kart 8 Deluxe", 59.99F));
        mesJeux.add(new JeuVideo("Starfield", 69.99F));
        mesJeux.add(new JeuVideo("Battlefield 2042", 59.99F));
        mesJeux.add(new JeuVideo("Splatoon 3", 59.99F));
        mesJeux.add(new JeuVideo("Resident Evil Village", 39.99F));
        mesJeux.add(new JeuVideo("Final Fantasy XVI", 69.99F));
        mesJeux.add(new JeuVideo("Diablo IV", 59.99F));


        monAdapter = new MyVideoGamesAdapter(mesJeux);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(monAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}