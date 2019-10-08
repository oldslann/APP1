package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ratio extends AppCompatActivity {
    private  static String TAG="main";

    EditText t1;
    EditText t2;
    EditText t3;
    double r1;
    double r2;
    double r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratio);

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1=findViewById(R.id.ttv1);
                t2=findViewById(R.id.ttv2);
                t3=findViewById(R.id.ttv3);

                CF(view);

            }
        });





    }

    public void CF(View btn)
    {
        if (t1.getText().toString().length()==0||t2.getText().toString().length()==0||t3.getText().toString().length()==0)
        {
            Toast.makeText(this,"please input number",Toast.LENGTH_SHORT).show();
        }

        else {
            r1=Double.valueOf(t1.getText().toString());
            r2=Double.valueOf(t2.getText().toString());
            r3=Double.valueOf(t3.getText().toString());
            Intent config = new Intent(this, Main3Activity.class);
            config.putExtra("dr", r1);
            config.putExtra("er", r2);
            config.putExtra("wr", r3);
            Log.i(TAG, "dr=  : " + r1);
            setResult(1, config);


            SharedPreferences sp=getSharedPreferences("myrate", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putFloat("dr",(float) r1);
            editor.putFloat("er",(float) r2);
            editor.putFloat("wr",(float) r3);
            editor.apply();
            finish();
        }


    }




}
