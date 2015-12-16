package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServicesActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    ListView servList;
    private ArrayList<String> services;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_activity);

        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);

        String str = prefHelper.getServ_electr();
        String str1 = prefHelper.getServ_coldW();
        String str2 = prefHelper.getServ_hotW();
        String str3 = prefHelper.getServ_gaz();
        String str4 = prefHelper.getServ_heat();

        services = new ArrayList();
        servList = ((ListView) findViewById(R.id.listView_services));
        adapter = new ArrayAdapter(this, R.layout.services_list, services);
        servList.setAdapter(adapter);

        if (str.equals("true")) {
            services.add(getString(R.string.electricity));
        }
        if (str1.equals("true")) {
            services.add(getString(R.string.cold_water));
        }
        if (str2.equals("true")) {
            services.add(getString(R.string.hot_water));
        }
        if (str3.equals("true")) {
            services.add(getString(R.string.gaz));
        }
        if (str4.equals("true")) {
            services.add(getString(R.string.heat));
        }
        if ((str.equals("false"))
                && (str1.equals("false"))
                && (str2.equals("false"))
                && (str3.equals("false"))
                && (str4.equals("false"))) {
            services.add(getString(R.string.no_service));
        }

        servList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(R.string.electricity))) {
                    startActivity(new Intent(ServicesActivity.this, ElectricityActivity.class));
                }
                if (strText.equalsIgnoreCase(getResources().getString(R.string.cold_water))) {
                    startActivity(new Intent(ServicesActivity.this, ColdWActivity.class));
                }
                if (strText.equalsIgnoreCase(getResources().getString(R.string.hot_water))) {
                    startActivity(new Intent(ServicesActivity.this, HotWActivity.class));
                }
                if (strText.equalsIgnoreCase(getResources().getString(R.string.gaz))) {
                    startActivity(new Intent(ServicesActivity.this, GazActivity.class));
                }
                if (strText.equalsIgnoreCase(getResources().getString(R.string.heat))) {
                    startActivity(new Intent(ServicesActivity.this, HeatActivity.class));
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, SettingsFragment.class));
        return super.onOptionsItemSelected(item);
    }
}
