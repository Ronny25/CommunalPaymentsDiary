package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ElectricityTaxes extends AppCompatActivity {

    private TextView from2;
    private TextView from3;
    private EditText tax1;
    private EditText tax2;
    private EditText tax3;
    private EditText till1;
    private EditText till2;

    void loadText() {
        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);

        String str1 = prefHelper.getElectr_taxes_till1();
        String str2 = prefHelper.getElectr_taxes_till2();
        String str3 = prefHelper.getElectr_taxes_tax1();
        String str4 = prefHelper.getElectr_taxes_tax2();
        String str5 = prefHelper.getElectr_taxes_tax3();

        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);

        from2.setText(String.valueOf(i + 1));
        from3.setText(String.valueOf(j + 1));
        till1.setText(str1);
        till2.setText(str2);
        tax1.setText(str3);
        tax2.setText(str4);
        tax3.setText(str5);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.electricity_taxes);

        from2 = ((TextView) findViewById(R.id.secondFrom));
        from3 = ((TextView) findViewById(R.id.thirdFrom));
        till1 = ((EditText) findViewById(R.id.firstTill));
        till2 = ((EditText) findViewById(R.id.secondTill));
        tax1 = ((EditText) findViewById(R.id.firstTax));
        tax2 = ((EditText) findViewById(R.id.secondTax));
        tax3 = ((EditText) findViewById(R.id.thirdTax));

        loadText();
    }

    void saveText() {
        Context context = getApplicationContext();
        PrefHelper prefHelper = new PrefHelper(context);

        prefHelper.setElectr_taxes_from2(from2.getText().toString());
        prefHelper.setElectr_taxes_from3(from3.getText().toString());
        prefHelper.setElectr_taxes_till1(till1.getText().toString());
        prefHelper.setElectr_taxes_till2(till2.getText().toString());
        prefHelper.setElectr_taxes_tax1(tax1.getText().toString());
        prefHelper.setElectr_taxes_tax2(tax2.getText().toString());
        prefHelper.setElectr_taxes_tax3(tax3.getText().toString());
    }

    public void taxes_save(View paramView) {
        saveText();

        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
}
