package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dataratio  extends AppCompatActivity implements Runnable {

    private  static String TAG="main";
    Handler handler;
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<HashMap<String, String>> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataratio);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what ==6 ) {
                    listView=(ListView)findViewById(R.id.listview1);

                    DBManager manager=new DBManager(dataratio.this);
                    List<RateItem> rateItems=manager.listAll();
                    if(rateItems.isEmpty())
                    {
                        listItems = (ArrayList<HashMap<String, String>>) msg.obj;
                        for (int k=0;k<listItems.size();k++)
                        {
                            RateItem ttt=new RateItem();
                           // ttt.setId(listItems.get(k).containsValue(""));
                            rateItems.add(ttt);

                        }

                    }
                    else
                    {

                    }



                    myAdapter = new MyAdapter(dataratio.this,
                            R.layout.list_item,
                            listItems);
                    Log.i(TAG, "listView");
                    listView.setAdapter(myAdapter);
                    listView.setEmptyView(findViewById(R.id.nodata));


                }



                super.handleMessage(msg);



            }
        };

        //开启子进程
        Thread th=new Thread(this);
        th.start();

    }

    @Override
    public void run() {
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
                map.put("curname",str1);
                map.put("currate",val);
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
}
