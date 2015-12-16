package com.kotkin.lg.r25.communalpaymentsdiary;

import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.SERVICES_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.PREVIOUS_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.COMMON_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.VOLUME_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.SUM_COLUMN;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class HistoryActivity extends AppCompatActivity {

    private ArrayList<HashMap> list;
    String el;

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
        float defCW = comCW - prevCW;
        float defHW = comHW - prevHW;
        float defGaz = comGaz - prevGaz;
        float defHeat = comHeat - prevHeat;

        int till1 = Integer.parseInt(prefHelper.getElectr_taxes_till1());
        float elTax1 = Float.parseFloat(prefHelper.getElectr_taxes_tax1());
        int till2 = Integer.parseInt(prefHelper.getElectr_taxes_till2());
        float elTax2 = Float.parseFloat(prefHelper.getElectr_taxes_tax2());
        int from3 = Integer.parseInt(prefHelper.getElectr_taxes_from3());
        float elTax3 = Float.parseFloat(prefHelper.getElectr_taxes_tax3());
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

        list = new ArrayList<HashMap>();


        HashMap temp = new HashMap();
        if (electr.equals("true")) {
            if (defEl <= till1) {
                el = String.valueOf(nf.format(defEl * elTax1));
            } else if (defEl <= till2) {
                el = String.valueOf(nf.format(till1 * elTax1 + (defEl - till1) * elTax2));
            } else if (defEl > from3) {
                el = String.valueOf(nf.format(till1 * elTax1 + (till2 - till1) * elTax2 + (defEl - till2 * elTax3)));
            }
            temp.put(SERVICES_COLUMN, getString(R.string.electricity));
            temp.put(PREVIOUS_COLUMN, String.valueOf(prevEl));
            temp.put(COMMON_COLUMN, String.valueOf(comEl));
            temp.put(VOLUME_COLUMN, String.valueOf(nf.format(defEl)));
            temp.put(SUM_COLUMN, el);
            list.add(temp);
            if (electr.equals("false")) {
                list.remove(temp);
            }
        }

        HashMap temp1 = new HashMap();
        if (home.equals("true")) {
            temp1.put(SERVICES_COLUMN, getString(R.string.homePay));
            temp1.put(PREVIOUS_COLUMN, "-");
            temp1.put(COMMON_COLUMN, "-");
            temp1.put(VOLUME_COLUMN, "-");
            temp1.put(SUM_COLUMN, String.valueOf(nf.format(taxHome)));
            list.add(temp1);
        } else {
            list.remove(temp1);
        }

        HashMap temp2 = new HashMap();
        if (coldW.equals("true")) {
            temp2.put(SERVICES_COLUMN, getString(R.string.cold_water));
            temp2.put(PREVIOUS_COLUMN, String.valueOf(prevCW));
            temp2.put(COMMON_COLUMN, String.valueOf(comCW));
            temp2.put(VOLUME_COLUMN, String.valueOf(nf.format(defCW)));
            temp2.put(SUM_COLUMN, String.valueOf(nf.format(defCW * taxCW)));
            list.add(temp2);
        } else {
            list.remove(temp2);
        }

        HashMap temp3 = new HashMap();
        if (hotW.equals("true")) {
            temp3.put(SERVICES_COLUMN, getString(R.string.hot_water));
            temp3.put(PREVIOUS_COLUMN, String.valueOf(prevHW));
            temp3.put(COMMON_COLUMN, String.valueOf(comHW));
            temp3.put(VOLUME_COLUMN, String.valueOf(nf.format(defHW)));
            temp3.put(SUM_COLUMN, String.valueOf(nf.format(defHW * taxHW)));
            list.add(temp3);
        } else {
            list.remove(temp3);
        }

        HashMap temp4 = new HashMap();
        if (gaz.equals("true")) {
            temp4.put(SERVICES_COLUMN, getString(R.string.gaz));
            temp4.put(PREVIOUS_COLUMN, String.valueOf(prevGaz));
            temp4.put(COMMON_COLUMN, String.valueOf(comGaz));
            temp4.put(VOLUME_COLUMN, String.valueOf(nf.format(defGaz)));
            temp4.put(SUM_COLUMN, String.valueOf(nf.format(defGaz * taxGaz)));
            list.add(temp4);
        } else {
            list.remove(temp4);
        }

        HashMap temp5 = new HashMap();
        if (heat.equals("true")) {
            temp5.put(SERVICES_COLUMN, getString(R.string.heat));
            temp5.put(PREVIOUS_COLUMN, String.valueOf(prevHeat));
            temp5.put(COMMON_COLUMN, String.valueOf(comHeat));
            temp5.put(VOLUME_COLUMN, String.valueOf(nf.format(defHeat)));
            temp5.put(SUM_COLUMN, String.valueOf(nf.format(defHeat * taxHeat)));
            list.add(temp5);
        } else {
            list.remove(temp5);
        }

        HashMap temp6 = new HashMap();
        if (tel.equals("true")) {
            temp6.put(SERVICES_COLUMN, getString(R.string.telephone));
            temp6.put(PREVIOUS_COLUMN, "-");
            temp6.put(COMMON_COLUMN, "-");
            temp6.put(VOLUME_COLUMN, "-");
            temp6.put(SUM_COLUMN, String.valueOf(nf.format(taxTel)));
            list.add(temp6);
        } else {
            list.remove(temp6);
        }

        HashMap temp7 = new HashMap();
        if (inter.equals("true")) {
            temp7.put(SERVICES_COLUMN, getString(R.string.internet));
            temp7.put(PREVIOUS_COLUMN, "-");
            temp7.put(COMMON_COLUMN, "-");
            temp7.put(VOLUME_COLUMN, "-");
            temp7.put(SUM_COLUMN, String.valueOf(nf.format(taxInter)));
            list.add(temp7);
        } else {
            list.remove(temp7);
        }

        HashMap temp8 = new HashMap();
        if (intCom.equals("true")) {
            temp8.put(SERVICES_COLUMN, getString(R.string.intercom));
            temp8.put(PREVIOUS_COLUMN, "-");
            temp8.put(COMMON_COLUMN, "-");
            temp8.put(VOLUME_COLUMN, "-");
            temp8.put(SUM_COLUMN, String.valueOf((nf.format(taxIntCom))));
            list.add(temp8);
        } else {
            list.remove(temp8);
        }

        HashMap temp9 = new HashMap();
        if (secur.equals("true")) {
            temp9.put(SERVICES_COLUMN, getString(R.string.security));
            temp9.put(PREVIOUS_COLUMN, "-");
            temp9.put(COMMON_COLUMN, "-");
            temp9.put(VOLUME_COLUMN, "-");
            temp9.put(SUM_COLUMN, String.valueOf((nf.format(taxSecur))));
            list.add(temp9);
        } else {
            list.remove(temp9);
        }

        HashMap temp10 = new HashMap();
        if (electr.equals("false")
                && home.equals("false")
                && coldW.equals("false")
                && hotW.equals("false")
                && gaz.equals("false")
                && heat.equals("false")
                && inter.equals("false")
                && intCom.equals("false")
                && secur.equals("false")) {
            temp10.put(SERVICES_COLUMN, getString(R.string.security));
            list.add(temp10);
        } else {
            list.remove(temp10);
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        fillData();

        ListView lview = (ListView) findViewById(R.id.history_listView);
        ListViewHistoryAdapter adapter = new ListViewHistoryAdapter(this, list);
        lview.setAdapter(adapter);
    }

    public void onResume() {
        super.onResume();
    }
}
