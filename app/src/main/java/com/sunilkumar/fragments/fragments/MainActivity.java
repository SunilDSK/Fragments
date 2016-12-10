package com.sunilkumar.fragments.fragments;

import android.app.Fragment;
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

        //Make student fragment to appear when application is launched
        switchFragments(1);

        //Change the fragment to student when clicked
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pass 1 to indicate student called this fragment
                switchFragments(1);


            }
        });

        //Change the fragment to teacher when clicked
        teachersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pass 2 to indicate teacher called this fragment
                switchFragments(2);
            }
        });
    }

    public void switchFragments(int i){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment output = null;
        if(i == 1){
            output = new Students_Fragment();

        }else {
            output = new Teachers_Fragments();
        }
        fragmentTransaction.replace(R.id.fragment_container,output);
        fragmentTransaction.commit();
    }
}
