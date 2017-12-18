package com.example.jasmin.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Spinner cities;
    int int_shift;
    int relative;
    int i_default;
    String item;
    String timeshift;
    TextView t, ausgabe;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);
    item = "Hour_LA";
        cities = findViewById(R.id.spinner);
        ArrayList<String> city_list = new ArrayList<String>();
        city_list.add("Los Angeles");
        city_list.add("Toronto");
        city_list.add("Reykjavik");
        city_list.add("Minsk");
        city_list.add("Tokyo");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, city_list);
        cities.setAdapter(adapter);

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());//getPreferences(MODE_PRIVATE);
        t = findViewById(R.id.textView);
        ausgabe = findViewById(R.id.textView2);

        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int set;
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                getSelect();
                set = prefs.getInt(item,i_default);
                t.setText("" + item);
                ausgabe.setText(""+ set + "Stunde(n)");
                System.out.println("Noew");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
         return;
            }
        });
    }





    public void writeBack(int number){
        SharedPreferences.Editor e = prefs.edit();
        e.putInt(item,number);
        System.out.println("" + item);
        e.commit();
        ausgabe.setText("" + number + "Stunde(n)");
        System.out.println("hier" + prefs.getInt(item, 0));
    }

    public void plus_click(View aView){
        int_shift = getSelect();
        System.out.print("Shift 1" + int_shift);
        int_shift++;
        System.out.print("Shift 2" + int_shift);
        writeBack(int_shift);
        t.setText(cities.getSelectedItem().toString());
    }

    public void minus_click(View aiew){
        int_shift = getSelect();
        System.out.print("Shift 1" + int_shift);
        int_shift = int_shift - 1;
        System.out.print("Shift 2" + int_shift);
        writeBack(int_shift);
        t.setText(cities.getSelectedItem().toString());
    }


    public int getSelect(){
        int shift;
       i_default = 0;
        String item_selection = cities.getSelectedItem().toString();
        String key = "Hour_LA";
        switch(item_selection) {
            case "Los Angeles":
                key="Hour_LA";
                i_default = -9;
                break;
            case "Toronto":
                key="Hour_Toronto";
                i_default = -1;
                break;
            case "Reykjavik":
                key="Hour_Reykjavik";
                i_default = -9;
                break;
            case "Minsk":
                key="Hour_Minsk";
                i_default = +2;
                break;
            case "Tokyo":
                key="Hour_Tokyo";
                i_default = +8;
                break;
        }
        item = key;
        System.out.println("Key" + key);

        shift = prefs.getInt(key,i_default);
        return shift;
    }

}

