package com.example.wallet.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.wallet.DataBase.DatabaseProvider;
import com.example.wallet.DataBase.WalletDatabase;
import com.example.wallet.model.Gelir;

import java.util.List;

public class GelirViewModel extends ViewModel {
    private LiveData<List<Gelir>> gelirs;
    public WalletDatabase database;

    public LiveData<List<Gelir>> getGelirs(Context context) {
        database = DatabaseProvider.getDatabase(context);
        gelirs = database.walletDao().getGelirs();

        return gelirs;

    }
}
