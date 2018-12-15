package org.pursuit.group_portfolio_hw_team_se7en;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RobertProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robert_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_rz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/email");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"robertzaratemorales@pursuit.org"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Hello! I found your profile.");
                email.putExtra(Intent.EXTRA_TEXT, "Dear Robert," + "");
                startActivity(Intent.createChooser(email, "Send Feedback:"));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup_rz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent browserIntent;
        String toastMsg = "You will be taken to a GitHub repo";
        switch (item.getItemId()) {
            case R.id.project1_rz:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/rzmorales/FirstGame"));
                startActivity(browserIntent);
                return true;
            case R.id.project2_rz:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/rzmorales/Java_Bank_Pursuit_Zarate-Morales_Robert"));
                startActivity(browserIntent);
                return true;
            case R.id.project3_rz:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/rzmorales/StoryApp"));
                startActivity(browserIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public void gitButtonRZ(View view) {
        Uri gitUri = Uri.parse("https://github.com/rzmorales");
        Intent intent = new Intent(Intent.ACTION_VIEW, gitUri);
        startActivity(intent);
    }
    public void linkedButtonRZ(View view) {
        Uri gitUri = Uri.parse("https://www.linkedin.com/in/robert-zarate-morales");
        Intent intent = new Intent(Intent.ACTION_VIEW, gitUri);
        startActivity(intent);
    }

}
