package com.skpissay.baseproject.screens.views;

import com.skpissay.baseproject.models.User;

import java.util.List;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by skpissay on 15/11/17.
 */

public interface LandingView {

    void onCompleted();

    void onError(String message);

    Observable<Response<List<User>>> getUsers(String pAccessToken, String username);

    void onUsers(Response<List<User>> response);

    Observable<Response<User>> getUser(String pName);

    void onUser(Response<User> response);
}
