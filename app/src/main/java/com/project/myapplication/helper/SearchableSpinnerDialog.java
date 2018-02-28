package com.project.myapplication.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.project.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Flendzz-Anitha on 2/27/2018.
 */

public class SearchableSpinnerDialog {


    Activity context;
    String dTitle, closeText;
    ArrayList<String> itemsString;
    OnSpinnerItemClick onSpinerItemClick;
    String itemTextColorCode;

    AlertDialog alertDialog;
    int pos;
    int style;


    public SearchableSpinnerDialog(Activity activity, ArrayList<String> itemsString,String dialogTitle, String closeText, String itemTextColorCode) {
        this.itemsString = itemsString;
        this.context = activity;
        this.dTitle=dialogTitle;
        this.closeText=closeText;
        this.itemTextColorCode=itemTextColorCode;
//        this.style=style;
    }

    public void bindOnSpinerListener(OnSpinnerItemClick onSpinerItemClick1) {
        this.onSpinerItemClick = onSpinerItemClick1;
    }


    public void showSearchableSpinnerDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        View v = context.getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView rippleViewClose = (TextView) v.findViewById(R.id.close);
        TextView title = (TextView) v.findViewById(R.id.spinerTitle);
        TextView closeTextView = (TextView) v.findViewById(R.id.close);
        title.setText(dTitle);
        closeTextView.setText(closeText);
        final ListView listView = (ListView) v.findViewById(R.id.list);
        final EditText searchBox = (EditText) v.findViewById(R.id.searchBox);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.items_view, itemsString);
        listView.setAdapter(adapter);
        adb.setView(v);
        alertDialog = adb.create();
        alertDialog.getWindow().getAttributes().windowAnimations = style;//R.style.DialogAnimations_SmileWindow;
        alertDialog.setCancelable(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                TextView t=(TextView)view.findViewById(R.id.text1);
                t.setTextColor(Color.parseColor(itemTextColorCode));
                for(int j=0;j<itemsString.size();j++)
                {
                    if(t.getText().toString().equalsIgnoreCase(itemsString.get(j).toString()))
                    {
                        pos=j;
                    }
                }
                onSpinerItemClick.onClick(itemsString,pos);
                alertDialog.dismiss();
            }
        });

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(searchBox.getText().toString().trim());
            }
        });

        rippleViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
