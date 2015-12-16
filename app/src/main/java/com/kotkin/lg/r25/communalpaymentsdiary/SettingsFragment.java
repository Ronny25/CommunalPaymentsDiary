package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingsFragment extends PreferenceActivity {

    private AppCompatDelegate mDelegate;

    protected void onCreate(Bundle savedInstanceState) {
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        Context context = getApplicationContext();
        final PrefHelper prefHelper = new PrefHelper(context);


        CheckBoxPreference checkboxElectr = (CheckBoxPreference) findPreference("checkboxElectr");
        CheckBoxPreference checkboxHome = (CheckBoxPreference) findPreference("checkboxHome");
        CheckBoxPreference checkboxColdW = (CheckBoxPreference) findPreference("checkboxColdW");
        CheckBoxPreference checkboxHotW = (CheckBoxPreference) findPreference("checkboxHotW");
        CheckBoxPreference checkboxGaz = (CheckBoxPreference) findPreference("checkboxGaz");
        CheckBoxPreference checkboxHeat = (CheckBoxPreference) findPreference("checkboxHeat");
        CheckBoxPreference checkboxTel = (CheckBoxPreference) findPreference("checkboxTel");
        CheckBoxPreference checkboxInter = (CheckBoxPreference) findPreference("checkboxInter");
        CheckBoxPreference checkboxIntCom = (CheckBoxPreference) findPreference("checkboxIntCom");
        CheckBoxPreference checkboxSecur = (CheckBoxPreference) findPreference("checkboxSecur");

        EditTextPreference homeTax_editText = (EditTextPreference) findPreference("homeTax_editText");
        EditTextPreference coldWTax_editText = (EditTextPreference) findPreference("coldWTax_editText");
        EditTextPreference hotWTax_editText = (EditTextPreference) findPreference("hotWTax_editText");
        EditTextPreference gazTax_editText = (EditTextPreference) findPreference("gazTax_editText");
        EditTextPreference heatTax_editText = (EditTextPreference) findPreference("heatTax_editText");
        EditTextPreference telTax_editText = (EditTextPreference) findPreference("telTax_editText");
        EditTextPreference interTax_editText = (EditTextPreference) findPreference("interTax_editText");
        EditTextPreference intComTax_editText = (EditTextPreference) findPreference("intComTax_editText");
        EditTextPreference securTax_editText = (EditTextPreference) findPreference("securTax_editText");

        checkboxElectr.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_electr("true");
                } else {
                    prefHelper.setServ_electr("false");
                }
                return true;
            }
        });
        checkboxHome.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_home("true");
                } else{
                    prefHelper.setServ_home("false");
                }
                return true;
            }
        });
        checkboxHotW.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_hotW("true");
                } else {
                    prefHelper.setServ_hotW("false");
                }
                return true;
            }
        });
        checkboxColdW.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_coldW("true");
                }else{
                    prefHelper.setServ_coldW("false");
                }
                return true;
            }
        });
        checkboxGaz.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_gaz("true");
                }else{
                    prefHelper.setServ_gaz("false");
                }
                return true;
            }
        });
        checkboxHeat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_heat("true");
                }else{
                    prefHelper.setServ_heat("false");
                }
                return true;
            }
        });
        checkboxTel.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_tel("true");
                }else{
                    prefHelper.setServ_tel("false");
                }
                return true;
            }
        });
        checkboxInter.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_inter("true");
                }else{
                    prefHelper.setServ_inter("false");
                }
                return true;
            }
        });
        checkboxIntCom.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_intCom("true");
                } else {
                    prefHelper.setServ_intCom("false");
                }
                return true;
            }
        });
        checkboxSecur.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.toString().equals("true")) {
                    prefHelper.setServ_secur("true");
                } else {
                    prefHelper.setServ_secur("false");
                }
                return true;
            }
        });

        Preference eltax = (Preference) findPreference("electrTaxes");
        eltax.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SettingsFragment.this, ElectricityTaxes.class));
                return false;
            }
        });

        if (homeTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxHome(homeTax_editText.getText().toString());
        }
        if (coldWTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxColdW(coldWTax_editText.getText().toString());
        }
        if (hotWTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxHW(hotWTax_editText.getText().toString());
        }
        if (gazTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxGaz(gazTax_editText.getText().toString());
        }
        if (heatTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxHeat(heatTax_editText.getText().toString());
        }
        if (telTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxTel(telTax_editText.getText().toString());
        }
        if (interTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxInter(interTax_editText.getText().toString());
        }
        if (intComTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxIntCom(intComTax_editText.getText().toString());
        }
        if (securTax_editText.getText().trim().length() > 0) {
            prefHelper.setTaxSecur(securTax_editText.getText().toString());
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().addContentView(view, params);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().setTitle(title);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    private AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }

}
