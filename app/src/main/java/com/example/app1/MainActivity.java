package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*private  static String TAG="main";   //text1
    TextView out;
    @Overrideprotected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text1);
       out=findViewById(R.id.out);
        out.setText("www");
        EditText inp =findViewById(R.id.inp);
        String str=inp.getText().toString();
        inp.setText("nasjsl");

        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               abc(view);
            }
        });
        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public void onClick(View view) {

    }

    public void abc(View view) {
        Log.i(TAG, "onClick: wwwwww");
        out.setText("qq");
    }

    */

    private  static String TAG="main";   //text1

    EditText cenc;
    TextView fahc;
    double i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tese2);
        cenc=findViewById(R.id.cenc);


        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fahc =findViewById(R.id.fahc);
                i=Integer.valueOf(cenc.getText().toString());
                i=i*1.8+32;
                fahc.setText(String.valueOf(i));
            }
        });



    }

    @Override
    public void onClick(View view) {

    }





}
