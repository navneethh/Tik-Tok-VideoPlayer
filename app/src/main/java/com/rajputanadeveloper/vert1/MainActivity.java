package com.rajputanadeveloper.vert1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
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
        bottomNavigationView.setOnNavigationItemSelectedListener(nagationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new home_fragment()).commit();



    }

    private BottomNavigationView.OnNavigationItemSelectedListener nagationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                /**
                 * Called when an item in the bottom navigation menu is selected.
                 *
                 * @param item The selected item
                 * @return true to display the item as the selected item and false if the item should not be
                 * selected. Consider setting non-selectable items as disabled preemptively to make them
                 * appear non-interactive.
                 */
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    BottomNavigationView b=findViewById(R.id.bottom_navi);
                    AppBarLayout t=findViewById(R.id.bottomm);
                    switch(item.getItemId()){
                        case R.id.nav_home:
                            selected=new home_fragment();

                            t.setBackgroundColor(getColor(R.color.transparent));

                            b.setBackgroundColor(getColor(R.color.transparent));
                            break;

                        case R.id.nav_notif:
                            selected=new notif_fragment();
                            b.setBackgroundColor(000000);
                            t.setBackgroundColor(000000);
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

                    return true;
                }


            };

}
