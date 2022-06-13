package com.example.wallet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CardViewNesneTutucu> {
    private Context mContext;
    private List<Giderler> giderTipleriList;

    public Adapter(Context mContext, List<Giderler> giderTipleriList) {
        this.mContext = mContext;
        this.giderTipleriList = giderTipleriList;
    }
    public class CardViewNesneTutucu extends RecyclerView.ViewHolder {

        public TextView giderTipi;
        public CardView cardViewId;
        public ImageView icon;

        public CardViewNesneTutucu(View view) {
            super(view);
            giderTipi = view.findViewById(R.id.giderTipi);
            cardViewId = view.findViewById(R.id.cardViewId);
            icon = view.findViewById(R.id.icon);
        }
    }

    @NonNull
    @Override
    public CardViewNesneTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardtasarim,parent,false);


        return new CardViewNesneTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewNesneTutucu holder, int position) {
        Giderler tip = giderTipleriList.get(position);

        holder.giderTipi.setText(tip.getTipAd());
        holder.icon.setImageResource(mContext.getResources().getIdentifier(tip.getTipIcon(),"drawable",mContext.getPackageName()));



        holder.cardViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,tip.getTipAd()+" seçildi",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),GirdiAlma.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return giderTipleriList.size();
    }


}
