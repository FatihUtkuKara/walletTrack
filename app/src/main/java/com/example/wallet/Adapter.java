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

public class Adapter extends RecyclerView.Adapter<Adapter.CardTasarımNesneleriniTutucu> {
    private Context mContext;
    private List<GiderTipleri>giderTipiList;


    public Adapter(Context mContext, List<GiderTipleri> giderTipiList) {
        this.mContext = mContext;
        this.giderTipiList = giderTipiList;

    }

    @NonNull
    @Override
    public CardTasarımNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardtasarim,parent,false);

        return new CardTasarımNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarımNesneleriniTutucu holder, int position) {
        GiderTipleri giderTipleri = giderTipiList.get(position);
        holder.giderTipi.setText(giderTipleri.getGiderAdı());
        holder.icon.setImageResource(mContext.getResources()
                .getIdentifier(giderTipleri.getIcon(),"drawable",mContext.getPackageName()));
        holder.cardViewId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, giderTipleri.getGiderAdı() +" "+mContext.getString(R.string.selected), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, GiderAlActivity.class);

                intent.putExtra("giderTip",giderTipleri.getGiderAdı());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return giderTipiList.size();
    }

    public class CardTasarımNesneleriniTutucu extends RecyclerView.ViewHolder{
        public CardView cardViewId;
        public TextView giderTipi;
        public ImageView icon;

        public CardTasarımNesneleriniTutucu(View view) {
            super(view);
            cardViewId = view.findViewById(R.id.cardViewId);
            giderTipi = view.findViewById(R.id.giderTipi);
            icon = view.findViewById(R.id.icon);

        }


    }
}
