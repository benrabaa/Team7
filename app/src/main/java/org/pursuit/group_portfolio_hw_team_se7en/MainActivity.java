package org.pursuit.group_portfolio_hw_team_se7en;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
