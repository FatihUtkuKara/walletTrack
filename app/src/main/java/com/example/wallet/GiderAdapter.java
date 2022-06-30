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
            Giderler giderler = giderlerList.get(position);
           holder.textViewYuzde.setText("%"+String.valueOf(giderlerList.get(position).getYüzde()));
            holder.textViewGiderTip.setText(giderlerList.get(position).getGiderAdı());
            holder.textViewSonuc.setText(String.valueOf(giderlerList.get(position).getTipBakiye()));
            if(giderlerList.get(position).getGiderAdı().equals("Spor")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.sports);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Eğlence")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.laugh);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Beslenme")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.salad);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Ev")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.house);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Eğitim")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.education);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Giyim")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.clothes);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Sağlık")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.health);
            }
            if(giderlerList.get(position).getGiderAdı().equals("Ulaşım")){
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
