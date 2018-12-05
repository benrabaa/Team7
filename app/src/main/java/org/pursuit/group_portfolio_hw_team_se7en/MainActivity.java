package org.pursuit.group_portfolio_hw_team_se7en;


import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_button);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        final NavigationView navigationView= findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_Pilin:
                        Intent pilinIntent = new Intent(getApplicationContext(),PilinActivity.class);
                        startActivity(pilinIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_Mohammed:
                        Intent mohamedIntent = new Intent(getApplicationContext(),MohamedActivity.class);
                        startActivity(mohamedIntent);
                        break;
                    case R.id.nav_Solomon:
                        Intent solomanIntent = new Intent(getApplicationContext(),SolomanActivity.class);
                        startActivity(solomanIntent);
                        break;
                    case R.id.nav_Robert:
                        Intent robertIntent = new Intent(getApplicationContext(),RobertActivity.class);
                        startActivity(robertIntent);
                        break;

                }
                return true;
            }
        });



    }
}
