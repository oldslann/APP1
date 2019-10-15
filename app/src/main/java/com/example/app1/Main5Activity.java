package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main5Activity extends AppCompatActivity implements Runnable, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private  static String TAG="main";
    Handler handler;
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<HashMap<String, String>> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what ==6 ) {
                    listView=(ListView)findViewById(R.id.listview1);


                    listItems = (ArrayList<HashMap<String, String>>) msg.obj;

                    myAdapter = new MyAdapter(Main5Activity.this,
                            R.layout.list_item,
                            listItems);
                    Log.i(TAG, "listView");
                    listView.setAdapter(myAdapter);
                    listView.setEmptyView(findViewById(R.id.nodata));
                    listView.setOnItemClickListener(Main5Activity.this);
                    listView.setOnItemLongClickListener(Main5Activity.this);


                }

                /*
                if (msg.what ==6 ) {


                    ArrayList<HashMap<String, String>> listItems = (ArrayList<HashMap<String, String>>) msg.obj;

                    ListAdapter adapter=new SimpleAdapter(Main5Activity.this,
                            listItems,
                            R.layout.list_item,
                            new String[]{"country","ratio"},
                            new int[]{R.id.list_i1,R.id.list_i2}
                            );
                    Log.i(TAG, "listView");
                    listView.setAdapter(adapter);

                } */



                /*
                *  if (msg.what ==6 ) {

                    List<String> list=(List<String>)msg.obj;
                    ListAdapter adapter=new ArrayAdapter<String>(
                            Main5Activity.this,
                            android.R.layout.simple_list_item_1,
                            lista
                    );
                    Log.i(TAG, "listView");
                    listView.setAdapter(adapter);

                }
                *
                * */

                super.handleMessage(msg);
            }
        };

        //开启子进程
        Thread th=new Thread(this);
        th.start();


    }


    @Override
    public void run() {


        Log.i(TAG, "run=  .......... " );
        for(int i=1;i<2;i++)
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
            Document doc= Jsoup.connect(url).get();
            Elements tables=doc.getElementsByTag("table");
            Element table6=tables.get(0);
            Elements tds=table6.getElementsByTag("td");

            System.out.println(tds.size());
            //List<String> list=new ArrayList<String>();
            ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();


            for(int i=0;i<=tds.size()-6;i+=6)
            {
                Element td1=tds.get(i);
                Element td2=tds.get(i+5);
                String str1=td1.text();
                String val=td2.text();
                HashMap<String,String> map=new HashMap<String, String>();
                map.put("country",str1);
                map.put("ratio",val);
                listItems.add(map);

                //list.add(str1+"----->"+val);

                Log.i(TAG, str1);
                Log.i(TAG, val);

            }


            Message msg=handler.obtainMessage(6);//获取对象 返回主线程
            //msg.what=6;
            //msg.obj=list;
            msg.obj=listItems;
            handler.sendMessage(msg);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }






    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        
        Object itemAtPosition = listView.getItemAtPosition(position);
        HashMap<String,String> map = (HashMap<String, String>) itemAtPosition;
        String titleStr = map.get("country");
        String detailStr = map.get("ratio");
        Log.i(TAG, "onItemClick: titleStr=" + titleStr);
        Log.i(TAG, "onItemClick: detailStr=" + detailStr);

        Intent config = new Intent(this, Ratio2.class);
        config.putExtra("country", titleStr);
        config.putExtra("ratio", detailStr);
        startActivity(config);
        /*
        TextView title = (TextView) view.findViewById(R.id.list_i1);
        TextView detail = (TextView) view.findViewById(R.id.list_i2);
        String title2 = String.valueOf(title.getText());
        String detail2 = String.valueOf(detail.getText());
        Log.i(TAG, "onItemClick: title2=" + title2);
        Log.i(TAG, "onItemClick: detail2=" + detail2);
        */
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示")
        .setMessage("是否删除当前数据")
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i(TAG,"longclick");

                        listItems.remove(position);
                        myAdapter.notifyDataSetChanged();//更新适配器
                    }
                })
                .setNegativeButton("否",null);
        builder.create().show();
        return true;
    }
}
