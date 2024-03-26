package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class screen1 extends AppCompatActivity {

    private ImageView backArrow;
    private LinearLayout icon1Layout, icon2Layout, icon3Layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        // Initialize views
        backArrow = findViewById(R.id.backArrow);
        icon1Layout = findViewById(R.id.icon1Layout);
        icon2Layout = findViewById(R.id.icon2Layout);
        icon3Layout = findViewById(R.id.icon3Layout);
        icon1Frag aFrag = new icon1Frag();
        icon2Frag bFrag = new icon2Frag();
        icon3Frag cFrag = new icon3Frag();

        // Set click listeners
        backArrow.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(screen1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        icon1Layout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                loadFragment(aFrag);
            }
        });
        icon2Layout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                loadFragment(bFrag);
            }
        });
        icon3Layout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                loadFragment(cFrag);
            }
        });

        // Load default fragment

        loadFragment(bFrag); // Replace DefaultFragment with your desired default fragment
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.addToBackStack(null); // Add transaction to back stack
        transaction.commit();
    }
}