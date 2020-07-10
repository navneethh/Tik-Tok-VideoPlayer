package com.rajputanadeveloper.vert1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rajputanadeveloper.vert1.Fragment.home_fragment;
import com.rajputanadeveloper.vert1.Fragment.notif_fragment;
import com.rajputanadeveloper.vert1.Fragment.profile_fragment;
import com.rajputanadeveloper.vert1.Fragment.search_fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    Fragment selected=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemReselectedListener(nagationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new home_fragment()).commit();



    }

    private BottomNavigationView.OnNavigationItemReselectedListener nagationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
                    switch(item.getItemId()){
                        case R.id.nav_home:
                            selected=new home_fragment();
                            break;

                        case R.id.nav_notif:
                            selected=new notif_fragment();
                            break;
                        case R.id.nav_profile:

                            selected=new profile_fragment();
                            break;
                        case R.id.nav_search:

                            selected=new search_fragment();
                            break;
                    }
                    if(selected!=null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,selected).commit();
                    }

                }
            };

}
