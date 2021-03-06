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

public class PilinProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilin_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_pc);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/email");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"pilinchong@pursuit.org"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Hello! I found your profile.");
                email.putExtra(Intent.EXTRA_TEXT, "Dear Pilin," + "");
                startActivity(Intent.createChooser(email, "Send Feedback:"));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup_pc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent browserIntent;
        String toastMsg = "You will be taken to a GitHub repo";
        switch (item.getItemId()) {
            case R.id.project1_pc:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pillmatictm/Mad_Libs_Android.git"));
                startActivity(browserIntent);
                return true;

            case R.id.project2_pc:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pillmatictm/StringGame.git\n"));
                startActivity(browserIntent);
                return true;

            case R.id.project3_pc:
                Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pillmatictm/codelab4.2.git"));
                startActivity(browserIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void gitButtonPC(View view) {
            Uri gitUri = Uri.parse("https://github.com/pillmatictm");
            Intent intent = new Intent(Intent.ACTION_VIEW, gitUri);
            startActivity(intent);
    }

    public void linkedButtonPC(View view) {
        Uri gitUri = Uri.parse("https://www.linkedin.com/in/pilin-chong-191702174/");
        Intent intent = new Intent(Intent.ACTION_VIEW, gitUri);
        startActivity(intent);
    }



}

