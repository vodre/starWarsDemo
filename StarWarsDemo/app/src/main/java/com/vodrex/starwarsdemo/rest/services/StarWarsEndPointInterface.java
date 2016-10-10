package com.vodrex.starwarsdemo.rest.services;


import retrofit2.Call;
import retrofit2.http.GET;
import com.vodrex.starwarsdemo.rest.plates.Characters;

/**
 * Created by vodrex on 10/9/16.
 */
public interface StarWarsEndPointInterface {

    @GET("people")
    Call<Characters> getCharacters();

}
