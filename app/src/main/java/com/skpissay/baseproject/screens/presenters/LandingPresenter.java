package com.skpissay.baseproject.screens.presenters;

import com.skpissay.baseproject.essentials.BasePresenter;
import com.skpissay.baseproject.models.User;
import com.skpissay.baseproject.screens.views.LandingView;

import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.Observer;

/**
 * Created by skpissay on 15/11/17.
 */

public class LandingPresenter extends BasePresenter {

    final LandingView mLandingView;

    public LandingPresenter(LandingView mLandingView) {
        this.mLandingView = mLandingView;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    Observer<Response<List<User>>> mObserverUserList = new Observer<Response<List<User>>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Response<List<User>> listResponse) {
            mLandingView.onUsers(listResponse);
        }
    };

    Observer<Response<User>> mObserverUser = new Observer<Response<User>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Response<User> userResponse) {
            mLandingView.onUser(userResponse);
        }
    };

    public void getUsers(String accessToken, String username) {
        unSubscribeMain();
        subscribe(mLandingView.getUsers(accessToken, username), mObserverUserList);
    }

    public void getUser(String accessToken) {
        unSubscribeMain();
        subscribe(mLandingView.getUser(accessToken), mObserverUser);
    }

    @Override
    public void onDestroy() {
        unSubscribeMain();
        unSubscribeSecondary();
        unSubscribeSearch();
    }
}
