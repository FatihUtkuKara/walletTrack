package com.example.wallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallet.viewModel.GelirViewModel;

import java.util.List;

public class GiderAdapter extends  RecyclerView.Adapter<GiderAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Giderler> giderList;


    public GiderAdapter(Context mContext, List<Giderler> giderList) {
        this.mContext = mContext;
        this.giderList = giderList;
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
            Giderler gider = giderList.get(position);
            // String fx = String.valueOf(gider.getTipBakiye());
            holder.textViewGiderTip.setText(gider.getGiderAdı());
            holder.textViewSonuc.setText(String.valueOf(gider.getTipBakiye()));
            holder.imageViewGiderTip.setImageResource(mContext.getResources()
                    .getIdentifier(gider.getGiderGörsel(), "drawable",mContext.getPackageName()));
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
