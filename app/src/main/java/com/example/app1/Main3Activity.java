package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener  {


    private  static String TAG="main";
    EditText et;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);





        Button btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et =findViewById(R.id.tV1);
                double i=Double.valueOf( et.getText().toString());
                i=i*0.14;
                t=findViewById(R.id.tV2);
                t.setText(""+i);


            }
        });

        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et =findViewById(R.id.tV1);
                double i=Double.valueOf( et.getText().toString());
                i=i*0.127;
                t=findViewById(R.id.tV2);
                t.setText(""+i);

            }
        });

        Button btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et =findViewById(R.id.tV1);
                double i=Double.valueOf( et.getText().toString());

                Log.i(TAG, "onClick1: "+i);
                i=i*167.8;
                Log.i(TAG, "onClick2: "+i);

                t=findViewById(R.id.tV2);
                t.setText(""+i);

            }
        });




    }


    @Override
    public void onClick(View view) {

    }
}

