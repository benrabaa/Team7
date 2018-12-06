package org.pursuit.group_portfolio_hw_team_se7en;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BenProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ben_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent browserIntent;
        switch (item.getItemId()){
            case R.id.project1:
                Toast.makeText(this,"@string/project1",Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/benrabaa/CTES"));
                startActivity(browserIntent);
                return true;
            case R.id.project2:
                Toast.makeText(this,"@string/project2",Toast.LENGTH_LONG).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/benrabaa/Bank-Teller"));
                startActivity(browserIntent);
                return true;
            case R.id.project3:
                Toast.makeText(this,"@string/project3",Toast.LENGTH_LONG).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/benrabaa/Mad-Libs"));
                startActivity(browserIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
