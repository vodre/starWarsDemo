package com.vodrex.starwarsdemo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.vodrex.starwarsdemo.R;
import com.vodrex.starwarsdemo.adapters.DetailsListAdapter;
import com.vodrex.starwarsdemo.model.Detail;
import com.vodrex.starwarsdemo.sweets.constraints.AppConst;

import java.util.ArrayList;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private String name = "";
    private String gender = "";
    private String height = "";
    private String birth = "";
    private String eyes = "";
    private String mass = "";
    private String skin = "";
    private ArrayList<Detail> details;
    private ImageView ivHead;
    private int currentImage;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    private void init() {
        (findViewById(R.id.fab_leia)).setOnClickListener(this);
        changeImage();
        retrieve();
        populate();
        actionBarSetup();
    }

    private void retrieve() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            name = extras.getString(AppConst.EXTRA_CHARACTER_NAME);
            gender = extras.getString(AppConst.EXTRA_CHARACTER_GENDER);
            height = extras.getString(AppConst.EXTRA_CHARACTER_HEIGHT);
            birth = extras.getString(AppConst.EXTRA_CHARACTER_BIRTH);
            eyes = extras.getString(AppConst.EXTRA_CHARACTER_EYES);
            mass = extras.getString(AppConst.EXTRA_CHARACTER_MASS);
            skin = extras.getString(AppConst.EXTRA_CHARACTER_SKIN);
        }
    }

    private void populate() {
        details = new ArrayList<Detail>();
        details.add(new Detail("Gender",gender));
        details.add(new Detail("Height",height));
        details.add(new Detail("Birth",birth));
        details.add(new Detail("Eyes",eyes));
        details.add(new Detail("Mass",mass));
        details.add(new Detail("Skin",skin));

        ListView listDetails = (ListView)findViewById(R.id.list_details);
        DetailsListAdapter adapter = new DetailsListAdapter(details);

        listDetails.setAdapter(adapter);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(context.getResources().getColor(R.color.yellow_force));
            toolbar.setSubtitleTextColor(context.getResources().getColor(R.color.yellow_force));
            toolbar.setTitle(name);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab_leia){
            changeImage();
        }
    }

    private void changeImage() {
        ivHead = (ImageView)findViewById(R.id.iv_parallax);
        int backGroundImage = 0;
        do {backGroundImage = getRandomBackgroundImage();
        }  while (currentImage == backGroundImage);
        currentImage = backGroundImage;
        ivHead.setImageResource(currentImage);
    }

    public int getRandomBackgroundImage() {
        int drawable = 0;
        Random r = new Random();
        int random = r.nextInt(3 - 0 + 1) + 1;
        switch(random) {
            case 1:
                drawable = R.drawable.un;
                break;
            case 2:
                drawable = R.drawable.deux;
                break;
            default:
                drawable = R.drawable.trois;
        }

        return drawable;
    }
}
