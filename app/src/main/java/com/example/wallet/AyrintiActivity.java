package com.example.wallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.wallet.model.Gelir;
import com.example.wallet.model.Gider;
import com.example.wallet.viewModel.GelirViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AyrintiActivity extends AppCompatActivity {
private RecyclerView rv2;
private ArrayList<Giderler> giderlerArrayList;
private GiderAdapter adapter;
private GelirViewModel tipModel;
int tipBakiye;
int giderBeslenme;
int giderEglence;
int giderEv;
int giderSpor;
int giderEgitim;
int giderUlasım;
int giderGiyim;
int giderSaglık;
String giderTipi;
public TextView textViewGider;
public TextView textViewGelir;
int gelirBakiye;
int giderBakiye;
int yüzdeEglence;
int yüzdeEv;
int yüzdeSpor;
int yüzdeBeslenme;
int yüzdeEgitim;
int yüzdeUlasım;
int yüzdeGiyim;
int yüzdeSaglık;
int toplamBakiye;
int oran;
private ArrayList<Giderler> giderlerList;
private TextView expenseTypes;
private TextView totalRevenue;
private TextView totalExpense;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayrinti);
        tipBakiye = 1;
        tipModel = new ViewModelProvider(this).get(GelirViewModel.class);
        textViewGelir = findViewById(R.id.textViewGelir);
        textViewGider = findViewById(R.id.textViewGider);
        expenseTypes = findViewById(R.id.textViewGiderTipleri);
        totalExpense =findViewById(R.id.textView2);
        totalRevenue =findViewById(R.id.textView);


        expenseTypes.setText(getString(R.string.expense_name));
        totalExpense.setText(getString(R.string.total_expense));
        totalRevenue.setText(getString(R.string.total_revenue));


        rv2=findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);

        rv2.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        adapter = new GiderAdapter(this);

        rv2.setAdapter(adapter);



        tipModel.getGiders(getApplicationContext()).observe(this, new Observer<List<Gider>>() {
            @Override
            public void onChanged(List<Gider> giders) {
                for (int i = 0; i < giders.size(); i++) {
                    giderBakiye = giderBakiye + giders.get(i).giderAmount;

                    if (giders.get(i).giderTipi.equals("Eğlence")){
                        giderEglence= giderEglence+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Ev")){
                        giderEv= giderEv+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Spor")){
                        giderSpor= giderSpor+giders.get(i).giderAmount;

                    }
                    else if (giders.get(i).giderTipi.equals("Eğitim")){
                        giderEgitim= giderEgitim+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Beslenme")){
                        giderBeslenme= giderBeslenme+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Sağlık")){
                        giderSaglık= giderSaglık+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Ulaşım")){
                        giderUlasım= giderUlasım+giders.get(i).giderAmount;
                    }
                    else if (giders.get(i).giderTipi.equals("Giyim")){
                        giderGiyim= giderGiyim+giders.get(i).giderAmount;
                    }

                }
                yüzdeEglence = (giderEglence*100)/giderBakiye;
                yüzdeEv = (giderEv*100)/giderBakiye;
                yüzdeSpor= (giderSpor*100)/giderBakiye;
                yüzdeEgitim = (giderEgitim*100)/giderBakiye;
                yüzdeBeslenme = (giderBeslenme*100)/giderBakiye;
                yüzdeUlasım = (giderUlasım*100)/giderBakiye;
                yüzdeSaglık = (giderSaglık*100)/giderBakiye;
                yüzdeGiyim = (giderGiyim*100)/giderBakiye;


                textViewGider.setText("" + giderBakiye);
                String fun = getString(R.string.fun);
                String health = getString(R.string.health);
                String clothes = getString(R.string.clothes);
                String house = getString(R.string.house);
                String education = getString(R.string.education);
                String sport = getString(R.string.sport);
                String transport = getString(R.string.transport);
                String eating= getString(R.string.eating);


                Giderler g1=  new Giderler(fun,"eglence",giderEglence,yüzdeEglence);
                Giderler g2=  new Giderler(education,"egitim",giderEgitim,yüzdeEgitim);
                Giderler g3=  new Giderler(house,"ev",giderEv,yüzdeEv);
                Giderler g4=  new Giderler(eating,"beslenme",giderBeslenme,yüzdeBeslenme);
                Giderler g5=  new Giderler(sport,"spor",giderSpor,yüzdeSpor);
                Giderler g6=  new Giderler(health,"saglık",giderSaglık,yüzdeSaglık);
                Giderler g7=  new Giderler(transport,"ulasım",giderUlasım,yüzdeUlasım);
                Giderler g8=  new Giderler(clothes,"giyim",giderGiyim,yüzdeGiyim);

                giderlerList =new ArrayList<>();
                giderlerList.add(g1);
                giderlerList.add(g2);
                giderlerList.add(g3);
                giderlerList.add(g4);
                giderlerList.add(g5);
                giderlerList.add(g6);
                giderlerList.add(g7);
                giderlerList.add(g8);

                adapter.setGiders(giderlerList);
            }
        });

        tipModel.getGelirs(getApplicationContext()).observe(this, new Observer<List<Gelir>>() {
            @Override
            public void onChanged(List<Gelir> gelirs) {
                for (int i = 0; i < gelirs.size(); i++) {
                    gelirBakiye = gelirBakiye + gelirs.get(i).amount;

                }
                textViewGelir.setText("" + gelirBakiye);
            }
        });
    }
}