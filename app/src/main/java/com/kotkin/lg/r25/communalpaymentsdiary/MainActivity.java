package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String el1;
    MainListViewAdapter mainListViewAdapter;
    ArrayList<Model> services = new ArrayList();

    void fillData() {
        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);

        String electr = prefHelper.getServ_electr();
        String home = prefHelper.getServ_home();
        String coldW = prefHelper.getServ_coldW();
        String hotW = prefHelper.getServ_hotW();
        String gaz = prefHelper.getServ_gaz();
        String heat = prefHelper.getServ_heat();
        String tel = prefHelper.getServ_tel();
        String inter = prefHelper.getServ_inter();
        String intCom = prefHelper.getServ_intCom();
        String secur = prefHelper.getServ_secur();

        float prevEl = Float.parseFloat(prefHelper.getPrevEl());
        float comEl = Float.parseFloat(prefHelper.getCommonEl());
        float prevCW = Float.parseFloat(prefHelper.getPrevCW());
        float comCW = Float.parseFloat(prefHelper.getCommonCW());
        float prevHW = Float.parseFloat(prefHelper.getPrevHW());
        float comHW = Float.parseFloat(prefHelper.getCommonHW());
        float prevGaz = Float.parseFloat(prefHelper.getPrevGaz());
        float comGaz = Float.parseFloat(prefHelper.getCommonGaz());
        float prevHeat = Float.parseFloat(prefHelper.getPrevHeat());
        float comHeat = Float.parseFloat(prefHelper.getCommonHeat());

        float defEl = comEl - prevEl;
        int till1 = Integer.parseInt(prefHelper.getElectr_taxes_till1());
        float tax1 = Float.parseFloat(prefHelper.getElectr_taxes_tax1());
        int till2 = Integer.parseInt(prefHelper.getElectr_taxes_till2());
        float tax2 = Float.parseFloat(prefHelper.getElectr_taxes_tax2());
        int from3 = Integer.parseInt(prefHelper.getElectr_taxes_from3());
        float tax3 = Float.parseFloat(prefHelper.getElectr_taxes_tax3());

        float taxCW = Float.parseFloat(prefHelper.getTaxColdW());
        float taxHW = Float.parseFloat(prefHelper.getTaxHW());
        float taxGaz = Float.parseFloat(prefHelper.getTaxGaz());
        float taxHeat = Float.parseFloat(prefHelper.getTaxHeat());
        float taxHome = Float.parseFloat(prefHelper.getTaxHome());
        float taxTel = Float.parseFloat(prefHelper.getTaxTel());
        float taxInter = Float.parseFloat(prefHelper.getTaxInter());
        float taxIntCom = Float.parseFloat(prefHelper.getTaxIntCom());
        float taxSecur = Float.parseFloat(prefHelper.getTaxSecur());

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        if (electr.equals("true")) {
            if (defEl <= till1) {
                el1 = String.valueOf(nf.format(defEl * tax1));
            } else if (defEl <= till2) {
                el1 = String.valueOf(nf.format(till1 * tax1 + (defEl - till1) * tax2));
            } else if (defEl > from3) {
                el1 = String.valueOf(nf.format(till1 * tax1 + (till2 - till1) * tax2 + (defEl - till2 * tax3)));
            }
            services.add(new Model(getString(R.string.electricity), el1, false));

            if (home.equals("true")) {
                services.add(new Model(getString(R.string.homePay), String.valueOf(nf.format(taxHome)), false));
            }
            if (coldW.equals("true")) {
                services.add(new Model(getString(R.string.cold_water), String.valueOf(nf.format((comCW - prevCW) * taxCW)), false));
            }
            if (hotW.equals("true")) {
                services.add(new Model(getString(R.string.hot_water), String.valueOf(nf.format((comHW - prevHW) * taxHW)), false));
            }
            if (gaz.equals("true")) {
                services.add(new Model(getString(R.string.gaz), String.valueOf(nf.format((comGaz - prevGaz) * taxGaz)), false));
            }
            if (heat.equals("true")) {
                services.add(new Model(getString(R.string.heat), String.valueOf(nf.format((comHeat - prevHeat) * taxHeat)), false));
            }
            if (tel.equals("true")) {
                services.add(new Model(getString(R.string.telephone), String.valueOf(nf.format(taxTel)), false));
            }
            if (inter.equals("true")) {
                services.add(new Model(getString(R.string.internet), String.valueOf(nf.format(taxInter)), false));
            }
            if (intCom.equals("true")) {
                services.add(new Model(getString(R.string.intercom), String.valueOf(nf.format(taxIntCom)), false));
            }
            if (secur.equals("true")) {
                services.add(new Model(getString(R.string.security), String.valueOf(nf.format(taxSecur)), false));
            }
            if ((electr.equals("false"))
                    && (home.equals("false"))
                    && (coldW.equals("false"))
                    && (hotW.equals("false"))
                    && (gaz.equals("false"))
                    && (heat.equals("false"))
                    && (tel.equals("false"))
                    && (inter.equals("false"))
                    && (intCom.equals("false"))
                    && (secur.equals("false"))) {
                services.add(new Model(getString(R.string.no_service), "", false));
            }
        }
    }

    public void history(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();

        mainListViewAdapter = new MainListViewAdapter(this, services);
        ((ListView) findViewById(R.id.mainServices_listView)).setAdapter(mainListViewAdapter);
    }

    public void onResume() {
        super.onResume();
    }

    public void settings(View view) {
        startActivity(new Intent(this, SettingsFragment.class));
    }

    public void tobotlay(View view) {
        startActivity(new Intent(this, ServicesActivity.class));
    }
}
