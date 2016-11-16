package com.rba.demomvp.api;

import com.rba.demomvp.model.response.LoginResponse;
import com.rba.demomvp.util.Constant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ricardo Bravo on 16/11/16.
 */


public interface DemoApi {

    @FormUrlEncoded
    @POST(Constant.URL_USER_LOGIN)
    Call<LoginResponse> login(@FieldMap Map<String, String> data);

}
