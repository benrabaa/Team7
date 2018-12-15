package org.pursuit.group_portfolio_hw_team_se7en;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

public class LanguageActivity extends AppCompatActivity {


    // Create a VideoView variable, a MediaPlayer variable, and an int to hold the current
    // video position.
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    private RadioGroup radioGroup;
    private RadioButton radionButton;
    private   String language="ar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        // Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.videoView);

        // Build your video Uri
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.introw); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.

        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        // Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });

        // language

        radioGroup= findViewById(R.id.radioGroup);
        Button buttonApply=findViewById(R.id.languageButton);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchSecondActivity();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radionId=radioGroup.getCheckedRadioButtonId();
                radionButton=findViewById(radionId);
            }
        });


    }

    public void launchSecondActivity (){
        int radionId=radioGroup.getCheckedRadioButtonId();
        radionButton=findViewById(radionId);
        if("Arabic".equals(radionButton.getText().toString())){
            language="ar";
        }else if("English".equals(radionButton.getText().toString())){
            language="en";
        }else{
            language="es";
        }
        Bundle bundle =new Bundle();
        bundle.putString("lan",language);
        Intent intent =new Intent(this,MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


//        Intent intent =new Intent(this,MainActivity.class);
//        intent.putExtra("lan",language);
//        startActivity(intent);
    }

    public void checkButton(View v){
        int radionId=radioGroup.getCheckedRadioButtonId();
        radionButton=findViewById(radionId);
    }

    /*================================ Important Section! ================================
    We must override onPause(), onResume(), and onDestroy() to properly handle our
    VideoView.
     */


    @Override
    protected void onPause() {
        super.onPause();
        // Capture the current video position and pause the video.
        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Restart the video when resuming the Activity
        videoBG.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // When the Activity is destroyed, release our MediaPlayer and set it to null.
        mMediaPlayer.release();
        mMediaPlayer = null;
    }


}
