package com.example.app1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener  {


    private  static String TAG="main";
    EditText et;
    TextView t;
    double r1=0.14;
    double r2=0.127;
    double r3=167.8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);







        Button btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               OC(view,r1);


            }
        });

        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OC(view,r2);

            }
        });

        Button btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OC(view,r3);

            }
        });


        Button btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Newo();
            }
        });






    }


    @Override
    public void onClick(View view) {



    }

    public void  OC(View view,double r)
    {

        et =findViewById(R.id.tV1);
        if(et.getText().toString().length()==0)
        {
            Toast.makeText(this,"please input number",Toast.LENGTH_SHORT).show();
        }
        else {
            double i = Double.valueOf(et.getText().toString());
            i = i * r;
            t = findViewById(R.id.tV2);
            Log.i(TAG, "onClick1: " + i);
            t.setText("" + i);
        }



    }



    public void  Newo()
    {
        Intent ratio=new Intent(this,Ratio.class);

        startActivityForResult(ratio,1);

        //startActivity(ratio);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1&&resultCode==1)
        {
            r1=data.getDoubleExtra("dr",0.00);
            r2=data.getDoubleExtra("er",0.00);
            r3=data.getDoubleExtra("wr",0.00);
            Log.i(TAG, "dr=  : " + r1);
        }



        super.onActivityResult(requestCode, resultCode, data);
    }
}

