package com.example.rmedhi.app_chalk.api;

import com.example.rmedhi.app_chalk.fetch_api.Fetch_all_polls;
import com.example.rmedhi.app_chalk.fetch_api.Fetch_api;
import com.example.rmedhi.app_chalk.send_api.Send_api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by R Medhi on 08-05-2017.
 */

public interface Poll_service {
    @FormUrlEncoded
    @POST("signup")
    Call<Fetch_api> api_user_signup(@Field("email") String email, @Field("pswd") String password);

    @FormUrlEncoded
    @POST("login")
    Call<Fetch_api> api_user_login(@Field("email") String email, @Field("pswd") String password);

    @POST("fetch-polls")
    Call <Fetch_all_polls> api_fetch_all_polls();
}

