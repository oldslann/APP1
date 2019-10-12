package com.example.app1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main3Activity extends AppCompatActivity implements Runnable{


    private  static String TAG="main";
    EditText et;
    TextView t;
    double r1=0.14;
    double r2=0.127;
    double r3=167.8;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);






        SharedPreferences sharedPreferences=getSharedPreferences("myrate", Activity.MODE_PRIVATE);
        PreferenceManager.getDefaultSharedPreferences(this);
        r1=sharedPreferences.getFloat("dr",0.0f);
        r2=sharedPreferences.getFloat("er",0.0f);
        r3=sharedPreferences.getFloat("wr",0.0f);



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

        handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==5){



                    String so=(String)msg.obj;
                    String[] str= so.split(",");

                    for (int i=0;i<=str.length-1;i++)
                    {
                        Log.i(TAG, "rate  "+str[i] );
                    }
                   //Log.i(TAG, "get message=  "+str );


                    /*t=findViewById(R.id.tV2);
                    t.setText(str);
                    */  //测试

                }

                super.handleMessage(msg);
            }
        };

        //开启子进程
        Thread th=new Thread(this);
        th.start();






    }


    //@Override
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_1,menu);
        return true;
    }//菜单

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.m1_1)
        {
            Newo();
        }
            ;
        super.onOptionsItemSelected(item);



        return true;
    }//菜单



    //子进程
    @Override
    public void run() {

        Log.i(TAG, "run=  .......... " );
        for(int i=1;i<6;i++)
        {
            Log.i(TAG, "run i=  "+i );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }





        String url="http://www.usd-cny.com/bankofchina.htm";
        try {
            Document doc=Jsoup.connect(url).get();
            Elements tables=doc.getElementsByTag("table");
            Element table6=tables.get(0);
            Elements tds=table6.getElementsByTag("td");

            System.out.println(tds.size());
            /*

            for(int i=0;i<=tds.size()-6;i+=6)
            {
                Element td1=tds.get(i);
                Element td2=tds.get(i+5);
                String str1=td1.text();
                String val=td2.text();

                Log.i(TAG, str1);
                Log.i(TAG, val);



            }
            */

            String dr2=tds.get(161).text();
            Log.i(TAG, tds.get(156).text());
            Log.i(TAG, dr2);

            String er2=tds.get(47).text();
            Log.i(TAG, tds.get(42).text());
            Log.i(TAG, er2);

            String wr2=tds.get(83).text();
            Log.i(TAG, tds.get(78).text());
            Log.i(TAG, wr2);



            Message msg=handler.obtainMessage(5);//获取对象 返回主线程
            //msg.what=5;
            msg.obj=dr2+","+er2+","+wr2;
            handler.sendMessage(msg);







        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }





        /*try {
            URL url=new URL("http://www.usd-cny.com/icbc.htm");
            HttpURLConnection http=(HttpURLConnection) url.openConnection();
            InputStream in=http.getInputStream();
            String html = inputStream2String(in);
            Log.i(TAG, "run: html="+html);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


    }



//文件流转字符串
    private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "gb2312");
        while (true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }


}

