package com.example.marcosantonio.cnc_machinist;

import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import layout.Fragment_0;
import layout.Fragment_1;
import layout.Fragment_2;
import layout.Fragment_3;
import layout.HomeFragment;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_content,new HomeFragment());
        fragmentTransaction.commit();
        //getSupportActionBar().setTitle("Tela1");

        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navS1T1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Fragment_1());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle(R.string.window_1);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS1T2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Fragment_2());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle(R.string.item2);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS1T3:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Fragment_3());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle(R.string.item3);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS2T1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Fragment_0());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle(R.string.item4);
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS2T2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tela5");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }


}
