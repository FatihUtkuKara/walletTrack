package com.example.wallet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GiderAdapter extends  RecyclerView.Adapter<GiderAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Gider> giderList = new ArrayList<Gider>();
    private List<Giderler> giderlerList = new ArrayList<Giderler>();
    String fun;
    String eating;
    String sport;
    String education;
    String clothes;
    String health;
    String transport;
    String house;


    public GiderAdapter(Context mContext) {
        this.mContext = mContext;
    }







    public void setGiders(List<Giderler>giderlerList) {
        Collections.sort(giderlerList);
        Collections.reverse(giderlerList);
        this.giderlerList.clear();
        this.giderlerList = giderlerList;
        this.giderList.addAll(giderList);
        notifyDataSetChanged();

    }





    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gidertasarim,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {

            fun = mContext.getString(R.string.fun);
            health = mContext.getString(R.string.health);
            clothes = mContext.getString(R.string.clothes);
            house = mContext.getString(R.string.house);
            education = mContext.getString(R.string.education);
            sport = mContext.getString(R.string.sport);
            transport = mContext.getString(R.string.transport);
            eating= mContext.getString(R.string.eating);

            Giderler giderler = giderlerList.get(position);
           holder.textViewYuzde.setText("%"+String.valueOf(giderlerList.get(position).getYüzde()));
            holder.textViewGiderTip.setText(giderlerList.get(position).getGiderAdı());
            holder.textViewSonuc.setText(String.valueOf(giderlerList.get(position).getTipBakiye()));
            if(giderlerList.get(position).getGiderAdı().equals(sport)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.sports);
            }
            if(giderlerList.get(position).getGiderAdı().equals(fun)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.laugh);
            }
            if(giderlerList.get(position).getGiderAdı().equals(eating)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.salad);
            }
            if(giderlerList.get(position).getGiderAdı().equals(house)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.house);
            }
            if(giderlerList.get(position).getGiderAdı().equals(education)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.education);
            }
            if(giderlerList.get(position).getGiderAdı().equals(clothes)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.clothes);
            }
            if(giderlerList.get(position).getGiderAdı().equals(health)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.health);
            }
            if(giderlerList.get(position).getGiderAdı().equals(transport)){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.transport);
            }

    }

    @Override
    public int getItemCount() {
        return giderlerList.size();
    }

    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewGiderTip;
        public TextView textViewGiderTip;
        public TextView textViewSonuc;
        public TextView textViewYuzde;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewGiderTip = itemView.findViewById(R.id.imageViewGiderTip);
            textViewGiderTip = itemView.findViewById(R.id.textViewGiderTip);
            textViewSonuc= itemView.findViewById(R.id.TextViewSonuc);
            textViewYuzde = itemView.findViewById(R.id.textViewYuzde);

        }
    }

}
