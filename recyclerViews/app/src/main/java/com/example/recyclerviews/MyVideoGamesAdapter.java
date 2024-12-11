package com.example.recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyVideoGamesAdapter extends RecyclerView.Adapter<MyVideoGamesAdapter.MyViewHolder> {
    List<JeuVideo> mesJeux;

    MyVideoGamesAdapter(List<JeuVideo> mesJeux) {
        this.mesJeux = mesJeux;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.jeu_video_item, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.display(mesJeux.get(position));
    }

    @Override
    public int getItemCount(){
        return mesJeux.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mNameTv;
        private TextView mPricetv;

        MyViewHolder(View itemView){
            super(itemView);

            mNameTv = (TextView) itemView.findViewById(R.id.name);
            mPricetv = (TextView) itemView.findViewById(R.id.price);
        }

        void display(JeuVideo jeuVideo){
            mNameTv.setText(jeuVideo.getName());
            mPricetv.setText(jeuVideo.getPrice()+"£");
        }
    }
}














