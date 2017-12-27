package com.skpissay.baseproject.screens.ui.interfaces;

import android.view.View;

import com.skpissay.baseproject.models.User;

/**
 * Created by skpissay on 15/11/17.
 */

public interface RecyclerUsersListener {
    public void onInfoClick(int pPostion, User pUser, View pView);
    public void onInfoLongClick(int pPostion, User pUser, View pView);
}
