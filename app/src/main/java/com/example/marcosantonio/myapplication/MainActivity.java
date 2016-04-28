package com.example.marcosantonio.myapplication;

import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import layout.Tela1Fragment;
import layout.Tela2Fragment;
import layout.Tela3Fragment;
import layout.Tela4Fragment;
import layout.Tela5Fragment;

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
        fragmentTransaction.add(R.id.main_content,new Tela1Fragment());
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
                        fragmentTransaction.replace(R.id.main_content,new Tela1Fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tela1");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS1T2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Tela2Fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tela2");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS1T3:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Tela3Fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tela3");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS2T1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Tela4Fragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Tela4");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navS2T2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_content,new Tela5Fragment());
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
