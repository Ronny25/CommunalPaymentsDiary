package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ElectricityActivity extends AppCompatActivity {

    private EditText previousET;
    private EditText commonET;

    private DatabaseHelper db;

    private void insert() {
        String str1 = previousET.getText().toString().trim();
        String str2 = commonET.getText().toString().trim();
        db.addService(str1, str2);

        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        String str = new PrefHelper(getApplicationContext()).getCommonEl();
        previousET.setText(str);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electricity_activity);

        previousET = ((EditText) findViewById(R.id.previousEl_editText));
        commonET = ((EditText) findViewById(R.id.commonEl_editText));
        db = new DatabaseHelper(this);

        loadText();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, SettingsFragment.class));
        return super.onOptionsItemSelected(item);
    }

    void saveText() {
        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);
        prefHelper.setPrevEl(previousET.getText().toString());
        prefHelper.setCommonEl(commonET.getText().toString());
    }

    public void save_dbBut(View view) {
        insert();
        saveText();
    }
}
