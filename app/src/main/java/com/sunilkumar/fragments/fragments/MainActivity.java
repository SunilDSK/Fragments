package com.sunilkumar.fragments.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //UI elements
    Button studentButton,teachersButton;
    RelativeLayout fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References to ui elements
        studentButton = (Button) findViewById(R.id.studentButton);
        teachersButton = (Button) findViewById(R.id.teacherButton);
        fragment_container = (RelativeLayout)findViewById(R.id.fragment_container);

        //Fragment manager references


        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Students_Fragment studentsfragment = new Students_Fragment();
                fragmentTransaction.replace(R.id.fragment_container,studentsfragment);
                fragmentTransaction.commit();
            }
        });

        teachersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Teachers_Fragments teachersfragments = new Teachers_Fragments();
                fragmentTransaction.replace(R.id.fragment_container,teachersfragments);
                fragmentTransaction.commit();
            }
        });

    }
}
