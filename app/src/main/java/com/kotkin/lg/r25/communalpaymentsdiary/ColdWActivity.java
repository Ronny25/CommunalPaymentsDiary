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

public class ColdWActivity extends AppCompatActivity {

    private EditText commonET;
    private EditText previousET;

    void loadText() {
        String str = new PrefHelper(getApplicationContext()).getCommonCW();
        previousET.setText(str);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coldw_activity);

        previousET = ((EditText) findViewById(R.id.previousColdW_editText));
        commonET = ((EditText) findViewById(R.id.commonColdW_editText));

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

    public void saveColdW_but(View view) {
        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);

        prefHelper.setPrevCW(previousET.getText().toString());
        prefHelper.setCommonCW(commonET.getText().toString());

        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}

