package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity  implements View.OnClickListener{


    TextView t1;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button btn1_1=findViewById(R.id.btn1_1);
        btn1_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                t1=findViewById(R.id.score1);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+3;
                t1.setText(String.valueOf(i));


            }
        });
        Button btn1_2=findViewById(R.id.btn1_2);
        btn1_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                t1=findViewById(R.id.score1);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+2;
                t1.setText(String.valueOf(i));

            }
        });
        Button btn1_3=findViewById(R.id.btn1_3);
        btn1_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                t1=findViewById(R.id.score1);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+1;
                t1.setText(String.valueOf(i));
            }
        });

        Button btn2_1=findViewById(R.id.btn2_1);
        btn2_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                t1=findViewById(R.id.score2);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+3;
                t1.setText(String.valueOf(i));


            }
        });
        Button btn2_2=findViewById(R.id.btn2_2);
        btn2_2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                t1=findViewById(R.id.score2);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+2;
                t1.setText(String.valueOf(i));

            }
        });
        Button btn2_3=findViewById(R.id.btn2_3);
        btn2_3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                t1=findViewById(R.id.score2);;
                i=Integer.valueOf(t1.getText().toString());
                i=i+1;
                t1.setText(String.valueOf(i));
            }
        });













        Button btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                t1=findViewById(R.id.score1);;
                TextView t2=findViewById(R.id.score2);
                t1.setText("0");
                t2.setText("0");

            }
        });




    }

    public void onClick(View view) {

    }

    public void onClick1(View view,int j) {
        t1=findViewById(R.id.score1);;
        i=Integer.valueOf(t1.getText().toString());
        i=i+j;
        t1.setText(String.valueOf(i));

    }
    public void onClick2(View view,int j) {
        t1=findViewById(R.id.score2);;
        i=Integer.valueOf(t1.getText().toString());
        i=i+j;
        t1.setText(String.valueOf(i));

    }
}
