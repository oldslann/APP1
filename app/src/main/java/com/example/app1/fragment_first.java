package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_first extends Fragment {

    public fragment_first(){}

   public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle s)
   {
       return inflater.inflate(R.layout.activity_fragment_first,container,false);
   }

}
