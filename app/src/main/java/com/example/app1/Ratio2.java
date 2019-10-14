package com.example.app1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class Ratio2 extends AppCompatActivity {

    private static String TAG="main";
    String country="";
    double ratio=0;
    TextView country_t;
    EditText usr_i;
    TextView usr_o;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio2);
        Intent intent=getIntent();
        country=intent.getStringExtra("country");
        ratio=Double.valueOf(intent.getStringExtra("ratio"));

        country_t=findViewById(R.id.country);
        usr_i=findViewById(R.id.usr_print);
        usr_o=findViewById(R.id.usr_out);
        if (country.length()!=0) {
            Log.i(TAG, "reuqest" + country);
            Log.i(TAG, "" + ratio);
            country_t.setText(country);
        }


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
    }



}
