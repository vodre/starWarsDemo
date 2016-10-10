package com.vodrex.starwarsdemo.view;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.vodrex.starwarsdemo.R;
import com.vodrex.starwarsdemo.adapters.CharactersListAdapter;
import com.vodrex.starwarsdemo.rest.plates.Character;
import com.vodrex.starwarsdemo.rest.plates.Characters;
import com.vodrex.starwarsdemo.rest.services.StarWarsEndPointInterface;
import com.vodrex.starwarsdemo.sweets.constraints.AppConst;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersListActivity extends ListActivity {
    public static final String BASE_URL = "http://swapi.co/api/";
    private  List<Character> characters;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters_list);
        actionBarSetup();
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
            toolbar.setTitle("Wookie");
            toolbar.setTitleTextColor(context.getResources().getColor(R.color.yellow_force));
            toolbar.setSubtitleTextColor(context.getResources().getColor(R.color.yellow_force));
            toolbar.setSubtitle("May the Force be with you");
        }
    }


    private void init() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        fetchData(retrofit);
    }

    private void fetchData(Retrofit retrofit) {
        StarWarsEndPointInterface apiService = retrofit.create(StarWarsEndPointInterface.class);
        Call<Characters> call = apiService.getCharacters();

        call.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                int statusCode = response.code();
                if (statusCode == 200){
                    Characters charactersResponse = response.body();
                    characters = charactersResponse.getResults();
                    ListAdapter adapter = new CharactersListAdapter(characters);
                    setListAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Character character =  characters.get(position);
        Intent intent = new Intent(CharactersListActivity.this, DetailsActivity.class);
        intent.putExtra(AppConst.EXTRA_CHARACTER_NAME, character.getName());
        intent.putExtra(AppConst.EXTRA_CHARACTER_GENDER, character.getGender());
        intent.putExtra(AppConst.EXTRA_CHARACTER_HEIGHT, character.getHeight());
        intent.putExtra(AppConst.EXTRA_CHARACTER_BIRTH, character.getBirthYear());
        intent.putExtra(AppConst.EXTRA_CHARACTER_EYES, character.getEyeColor());
        intent.putExtra(AppConst.EXTRA_CHARACTER_MASS, character.getMass());
        intent.putExtra(AppConst.EXTRA_CHARACTER_SKIN, character.getSkinColor());
        startActivity(intent);
    }
}
