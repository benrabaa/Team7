package org.pursuit.group_portfolio_hw_team_se7en;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    private String language="en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState!=null){
//            language=savedInstanceState.getString("lan");
//            setApplocale(language);
//
//        }else {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            language = bundle.getString("lan");
        }
        setApplocale(language);
//        }

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_button);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView1 = findViewById(R.id.nav_view);

        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_Pilin:
                        Intent pilinIntent = new Intent(getApplicationContext(), PilinProfile.class);
                        startActivity(pilinIntent);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_Mohamed:
                        Intent mohamedIntent = new Intent(getApplicationContext(), BenProfile.class);
                        mohamedIntent.putExtra("lan",language);
                        startActivity(mohamedIntent);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_Solomon:

                        Intent solomonIntent = new Intent(getApplicationContext(), SolomonProfile.class);
                        startActivity(solomonIntent);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_Robert:
                        Intent robertIntent = new Intent(getApplicationContext(), RobertProfile.class);
                        startActivity(robertIntent);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("lan",language);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            language = savedInstanceState.getString("lan");
            setApplocale(language);
        }
    }

    private void setApplocale(String locleCode){
        Resources resources=getResources();
        DisplayMetrics displayMetrics=resources.getDisplayMetrics();
        Configuration configuration=resources.getConfiguration();
        configuration.setLocale(new Locale(locleCode));
        resources.updateConfiguration(configuration,displayMetrics);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
