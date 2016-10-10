package com.vodrex.starwarsdemo.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vodrex.starwarsdemo.R;
import com.vodrex.starwarsdemo.sweets.media.CustomVideoView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomVideoView videoIntro;
    private static final long SPLASH_SCREEN_DELAY = 900000;

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            startMainActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        init();
        super.onResume();
    }

    private void init() {
        startBackgroundVideo();
        showSkipMessage();
        startTimer();
    }

    private void showSkipMessage() {
        View parentLayout = findViewById(R.id.root_view);
        parentLayout.setOnClickListener(this);
        Snackbar snackbar = Snackbar.make(parentLayout, "Touch the screen to skip Intro", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private void startBackgroundVideo() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int h = displaymetrics.heightPixels;
        int w = displaymetrics.widthPixels;
        Uri uri_video = Uri.parse("android.resource://" + getPackageName() + "/raw/intro");
        videoIntro = (CustomVideoView)findViewById(R.id.intro_video);
        videoIntro.setVideoURI(uri_video);
        videoIntro.setDimensions(w, h);
        videoIntro.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    private void startMainActivity() {
        startActivity(new Intent().setClass(SplashActivity.this, CharactersListActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        startMainActivity();
    }
}
