package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelper {

    private static final String SERV_PREF = "services_preferences";
    private SharedPreferences myPref;
    private SharedPreferences.Editor prefEd;

    private String commonCW = "common_cold_water";
    private String commonEl = "common_electricity";
    private String commonGaz = "common_gaz";
    private String commonHW = "common_hot_water";
    private String commonHeat = "common_heat";

    private String electr_taxes_from2 = "electricity_taxes_from2";
    private String electr_taxes_from3 = "electricity_taxes_from3";
    private String electr_taxes_tax1 = "electricity_taxes_tax1";
    private String electr_taxes_tax2 = "electricity_taxes_tax2";
    private String electr_taxes_tax3 = "electricity_taxes_tax3";
    private String electr_taxes_till1 = "electricity_taxes_till1";
    private String electr_taxes_till2 = "electricity_taxes_till2";

    private String prevCW = "previous_cold_water";
    private String prevEl = "previous_electricity";
    private String prevGaz = "previous_gaz";
    private String prevHW = "previous_hot_water";
    private String prevHeat = "previous_heat";
    private String serv_coldW = "coldW_pref";
    private String serv_electr = "electr_pref";
    private String serv_gaz = "gaz_pref";
    private String serv_heat = "heat_pref";
    private String serv_home = "home_pref";
    private String serv_hotW = "hotW_pref";
    private String serv_intCom = "intCom_pref";
    private String serv_inter = "inter_pref";
    private String serv_secur = "secur_pref";
    private String serv_tel = "tel_pref";
    private String taxColdW = "coldW_tax";
    private String taxGaz = "gaz_tax";
    private String taxHW = "hotW_tax";
    private String taxHeat = "heat_tax";
    private String taxHome = "home_tax";
    private String taxIntCom = "intercom_tax";
    private String taxInter = "internet_tax";
    private String taxSecur = "security_tax";
    private String taxTel = "telephone_tax";

    public PrefHelper(Context paramContext) {
        this.myPref = paramContext.getSharedPreferences("services_preferences", 0);
        this.prefEd = this.myPref.edit();
    }

    public String getCommonCW() {
        return this.myPref.getString(this.commonCW, "0");
    }

    public String getCommonEl() {
        return this.myPref.getString(this.commonEl, "0");
    }

    public String getCommonGaz() {
        return this.myPref.getString(this.commonGaz, "0");
    }

    public String getCommonHW() {
        return this.myPref.getString(this.commonHW, "0");
    }

    public String getCommonHeat() {
        return this.myPref.getString(this.commonHeat, "0");
    }

    public String getElectr_taxes_from2() {
        return this.myPref.getString(this.electr_taxes_from2, "0");
    }

    public String getElectr_taxes_from3() {
        return this.myPref.getString(this.electr_taxes_from3, "0");
    }

    public String getElectr_taxes_tax1() {
        return this.myPref.getString(this.electr_taxes_tax1, "0.0");
    }

    public String getElectr_taxes_tax2() {
        return this.myPref.getString(this.electr_taxes_tax2, "0.0");
    }

    public String getElectr_taxes_tax3() {
        return this.myPref.getString(this.electr_taxes_tax3, "0.0");
    }

    public String getElectr_taxes_till1() {
        return this.myPref.getString(this.electr_taxes_till1, "0");
    }

    public String getElectr_taxes_till2() {
        return this.myPref.getString(this.electr_taxes_till2, "0");
    }

    public String getPrevCW() {
        return this.myPref.getString(this.prevCW, "0");
    }

    public String getPrevEl() {
        return this.myPref.getString(this.prevEl, "0");
    }

    public String getPrevGaz() {
        return this.myPref.getString(this.prevGaz, "0");
    }

    public String getPrevHW() {
        return this.myPref.getString(this.prevHW, "0");
    }

    public String getPrevHeat() {
        return this.myPref.getString(this.prevHeat, "0");
    }

    public String getServ_coldW() {
        return this.myPref.getString(this.serv_coldW, "unknown");
    }

    public String getServ_electr() {
        return this.myPref.getString(this.serv_electr, "unknown");
    }

    public String getServ_gaz() {
        return this.myPref.getString(this.serv_gaz, "unknown");
    }

    public String getServ_heat() {
        return this.myPref.getString(this.serv_heat, "unknown");
    }

    public String getServ_home() {
        return this.myPref.getString(this.serv_home, "unknown");
    }

    public String getServ_hotW() {
        return this.myPref.getString(this.serv_hotW, "unknown");
    }

    public String getServ_intCom() {
        return this.myPref.getString(this.serv_intCom, "unknown");
    }

    public String getServ_inter() {
        return this.myPref.getString(this.serv_inter, "unknown");
    }

    public String getServ_secur() {
        return this.myPref.getString(this.serv_secur, "unknown");
    }

    public String getServ_tel() {
        return this.myPref.getString(this.serv_tel, "unknown");
    }

    public String getTaxColdW() {
        return this.myPref.getString(this.taxColdW, "0");
    }

    public String getTaxGaz() {
        return this.myPref.getString(this.taxGaz, "0");
    }

    public String getTaxHW() {
        return this.myPref.getString(this.taxHW, "0");
    }

    public String getTaxHeat() {
        return this.myPref.getString(this.taxHeat, "0");
    }

    public String getTaxHome() {
        return this.myPref.getString(this.taxHome, "0");
    }

    public String getTaxIntCom() {
        return this.myPref.getString(this.taxIntCom, "0");
    }

    public String getTaxInter() {
        return this.myPref.getString(this.taxInter, "0");
    }

    public String getTaxSecur() {
        return this.myPref.getString(this.taxSecur, "0");
    }

    public String getTaxTel() {
        return this.myPref.getString(this.taxTel, "0");
    }

    public void setCommonCW(String paramString) {
        this.prefEd.putString(this.commonCW, paramString).commit();
    }

    public void setCommonEl(String paramString) {
        this.prefEd.putString(this.commonEl, paramString).commit();
    }

    public void setCommonGaz(String paramString) {
        this.prefEd.putString(this.commonGaz, paramString).commit();
    }

    public void setCommonHW(String paramString) {
        this.prefEd.putString(this.commonHW, paramString).commit();
    }

    public void setCommonHeat(String paramString) {
        this.prefEd.putString(this.commonHeat, paramString).commit();
    }

    public void setElectr_taxes_from2(String paramString) {
        this.prefEd.putString(this.electr_taxes_from2, paramString).commit();
    }

    public void setElectr_taxes_from3(String paramString) {
        this.prefEd.putString(this.electr_taxes_from3, paramString).commit();
    }

    public void setElectr_taxes_tax1(String paramString) {
        this.prefEd.putString(this.electr_taxes_tax1, paramString).commit();
    }

    public void setElectr_taxes_tax2(String paramString) {
        this.prefEd.putString(this.electr_taxes_tax2, paramString).commit();
    }

    public void setElectr_taxes_tax3(String paramString) {
        this.prefEd.putString(this.electr_taxes_tax3, paramString).commit();
    }

    public void setElectr_taxes_till1(String paramString) {
        this.prefEd.putString(this.electr_taxes_till1, paramString).commit();
    }

    public void setElectr_taxes_till2(String paramString) {
        this.prefEd.putString(this.electr_taxes_till2, paramString).commit();
    }

    public void setPrevCW(String paramString) {
        this.prefEd.putString(this.prevCW, paramString).commit();
    }

    public void setPrevEl(String paramString) {
        this.prefEd.putString(this.prevEl, paramString).commit();
    }

    public void setPrevGaz(String paramString) {
        this.prefEd.putString(this.prevGaz, paramString).commit();
    }

    public void setPrevHW(String paramString) {
        this.prefEd.putString(this.prevHW, paramString).commit();
    }

    public void setPrevHeat(String paramString) {
        this.prefEd.putString(this.prevHeat, paramString).commit();
    }

    public void setServ_coldW(String paramString) {
        this.prefEd.putString(this.serv_coldW, paramString).commit();
    }

    public void setServ_electr(String paramString) {
        this.prefEd.putString(this.serv_electr, paramString).commit();
    }

    public void setServ_gaz(String paramString) {
        this.prefEd.putString(this.serv_gaz, paramString).commit();
    }

    public void setServ_heat(String paramString) {
        this.prefEd.putString(this.serv_heat, paramString).commit();
    }

    public void setServ_home(String paramString) {
        this.prefEd.putString(this.serv_home, paramString).commit();
    }

    public void setServ_hotW(String paramString) {
        this.prefEd.putString(this.serv_hotW, paramString).commit();
    }

    public void setServ_intCom(String paramString) {
        this.prefEd.putString(this.serv_intCom, paramString).commit();
    }

    public void setServ_inter(String paramString) {
        this.prefEd.putString(this.serv_inter, paramString).commit();
    }

    public void setServ_secur(String paramString) {
        this.prefEd.putString(this.serv_secur, paramString).commit();
    }

    public void setServ_tel(String paramString) {
        this.prefEd.putString(this.serv_tel, paramString).commit();
    }

    public void setTaxColdW(String paramString) {
        this.prefEd.putString(this.taxColdW, paramString).commit();
    }

    public void setTaxGaz(String paramString) {
        this.prefEd.putString(this.taxGaz, paramString).commit();
    }

    public void setTaxHW(String paramString) {
        this.prefEd.putString(this.taxHW, paramString).commit();
    }

    public void setTaxHeat(String paramString) {
        this.prefEd.putString(this.taxHeat, paramString).commit();
    }

    public void setTaxHome(String paramString) {
        this.prefEd.putString(this.taxHome, paramString).commit();
    }

    public void setTaxIntCom(String paramString) {
        this.prefEd.putString(this.taxIntCom, paramString).commit();
    }

    public void setTaxInter(String paramString) {
        this.prefEd.putString(this.taxInter, paramString).commit();
    }

    public void setTaxSecur(String paramString) {
        this.prefEd.putString(this.taxSecur, paramString).commit();
    }

    public void setTaxTel(String paramString) {
        this.prefEd.putString(this.taxTel, paramString).commit();
    }
}

