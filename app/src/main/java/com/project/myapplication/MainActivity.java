package com.project.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.myapplication.helper.OnSpinnerItemClick;
import com.project.myapplication.helper.SearchableSpinnerDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SearchableSpinnerDialog searchableSpinnerDialog;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button) findViewById(R.id.btnClick);

        String stateArray[]= {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu","Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman and Nicobar", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Lakshadweep", "Delhi", "Pondicherry"};

        ArrayList<String> stateList = new ArrayList<String>();

        for (int i = 0; i < stateArray.length; i++) {
            stateList.add(stateArray[i]);
        }

        searchableSpinnerDialog = new SearchableSpinnerDialog(this, stateList, "Select State", "close", "#000000");

        btnClick.setOnClickListener(this);

        searchableSpinnerDialog.bindOnSpinerListener(new OnSpinnerItemClick() {
            @Override
            public void onClick(ArrayList<String> item, int position) {

                Toast.makeText(MainActivity.this, "You've selected "+ item.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        searchableSpinnerDialog.showSearchableSpinnerDialog();
    }
}
