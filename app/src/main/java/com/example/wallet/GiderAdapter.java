package com.example.wallet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import java.util.ArrayList;
import java.util.List;

public class GiderAdapter extends  RecyclerView.Adapter<GiderAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Gider> giderList = new ArrayList<Gider>();


    public GiderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setGiders(List<Gider> giderList){
        this.giderList.clear();
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
            // String fx = String.valueOf(gider.getTipBakiye());
            holder.textViewGiderTip.setText(giderList.get(position).giderTipi);
            holder.textViewSonuc.setText(String.valueOf(giderList.get(position).giderAmount));
            if(giderList.get(position).giderTipi.equals("Spor")){
                holder.imageViewGiderTip.setBackgroundResource(R.drawable.sports);
            }
    }

    @Override
    public int getItemCount() {
        return giderList.size();
    }

    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewGiderTip;
        public TextView textViewGiderTip;
        public TextView textViewSonuc;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewGiderTip = itemView.findViewById(R.id.imageViewGiderTip);
            textViewGiderTip = itemView.findViewById(R.id.textViewGiderTip);
            textViewSonuc= itemView.findViewById(R.id.TextViewSonuc);

        }
    }

}
