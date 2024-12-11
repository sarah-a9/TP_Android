package com.example.systemesolaire;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaneteAdapter extends RecyclerView.Adapter<PlaneteAdapter.PlaneteViewHolder> {

    private List<Planete> planeteList;
    private Context context;


    // Constructor that takes the list of planets
    PlaneteAdapter(Context context, List<Planete> planeteList) {
        this.context = context;
        this.planeteList = planeteList;
    }

    @NonNull
    @Override
    public PlaneteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_planete, parent, false);
        return new PlaneteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaneteViewHolder holder, int position) {
        // Bind the data to the view
        Planete planete = planeteList.get(position);
        holder.nom.setText(planete.getNom());
        holder.image.setImageResource(planete.getImageId());
        holder.display(planete);


        // Gérer le clic sur un élément
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("PLANETE", planete);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return planeteList.size(); // Return the size of the planet list
    }

    // ViewHolder to hold references to views
    class PlaneteViewHolder extends RecyclerView.ViewHolder {
        private TextView nom;  // TextView to display the planet's name
        private ImageView image; // ImageView to display the planet's image

        PlaneteViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom_planete);
            image = itemView.findViewById(R.id.image_planete);
        }

        void display(Planete planete) {
            // Set the planet's name and image using data from the Planete object
            nom.setText(planete.getNom());
            image.setImageResource(planete.getImageId());
        }
    }
}










