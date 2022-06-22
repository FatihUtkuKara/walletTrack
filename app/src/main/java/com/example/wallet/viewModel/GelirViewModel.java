package com.example.wallet.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wallet.DataBase.DatabaseProvider;
import com.example.wallet.DataBase.WalletDatabase;
import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;

import java.util.List;

public class GelirViewModel extends ViewModel {
    private LiveData<List<Gelir>> gelirs;
    private LiveData<List<Gider>> giders;
    public WalletDatabase database;

    public LiveData<List<Gelir>> getGelirs(Context context) {
        database = DatabaseProvider.getDatabase(context);
        gelirs = database.walletDao().getGelirs();

        return gelirs;

    }

    public LiveData<List<Gider>> getGiders(Context context){
        database = DatabaseProvider.getDatabase(context);
        giders  = database.walletDao().getGiders();

        return giders;
    }



}
