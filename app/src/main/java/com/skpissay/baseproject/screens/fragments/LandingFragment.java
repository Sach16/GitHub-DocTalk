package com.skpissay.baseproject.screens.fragments;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.skpissay.baseproject.R;
import com.skpissay.baseproject.baseclasses.BaseActivity;
import com.skpissay.baseproject.baseclasses.BaseFragment;
import com.skpissay.baseproject.di.components.DaggerLandingComponent;
import com.skpissay.baseproject.di.modules.LandingModule;
import com.skpissay.baseproject.models.User;
import com.skpissay.baseproject.rest.ApiInterface;
import com.skpissay.baseproject.rest.response.BasicResponse;
import com.skpissay.baseproject.screens.activities.HomeActivity;
import com.skpissay.baseproject.screens.presenters.HomePresenter;
import com.skpissay.baseproject.screens.presenters.LandingPresenter;
import com.skpissay.baseproject.screens.ui.helper.UsersAdapter;
import com.skpissay.baseproject.screens.ui.interfaces.RecyclerUsersListener;
import com.skpissay.baseproject.screens.views.HomeView;
import com.skpissay.baseproject.screens.views.LandingView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by skpissay on 19/07/17.
 */

public class LandingFragment extends BaseFragment implements LandingView, RecyclerUsersListener{

    public static final String ACCESS_TOKEN = "261bab595885e6bf8bb38e5a19795d25832d4fdb";

    @Nullable
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @BindView(R.id.search_et)
    EditText searchEt;

    @Inject
    LandingPresenter mLandingPresenter;

    @Inject
    ApiInterface mApiInterface;

    @Inject
    UsersAdapter mUsersRecycAdapter;

    private List<User> mUsers;
    private boolean m_cLoading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    LinearLayoutManager m_cLayoutManager;

    @Override
    protected void handleUIMessage(Message pObjMessage) {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.landing_fragment;
    }

    @Override
    protected void initViews(View view) {
        DaggerLandingComponent.builder()
                .homeActivityComponent(((HomeActivity) m_cObjMainActivity).getComponent())
                .landingModule(new LandingModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void init() {
        mUsers = new ArrayList<>();
        m_cLayoutManager = new LinearLayoutManager(m_cObjMainActivity);
        m_cLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(m_cLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = m_cLayoutManager.getChildCount();
                    totalItemCount = m_cLayoutManager.getItemCount();
                    pastVisiblesItems = m_cLayoutManager.findFirstVisibleItemPosition();

//                    int page = totalItemCount / 15;
                    if (m_cLoading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            m_cLoading = false;
                            Log.v("...", "Last Item Wow !");
                            //Do pagination.. i.e. fetch new data
//                            int lpage = page + 1;
//                            page = lpage;
//                            doPagination(lpage);
                        }
                    }
                }
            }
        });

        //Call Api
        searchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!searchEt.getText().toString().isEmpty())
                    mLandingPresenter.getUsers(ACCESS_TOKEN, searchEt.getText().toString().trim());
            }
        });
    }

    @Override
    protected String getEmptyTitleText() {
        return null;
    }

    @Override
    protected String getEmptyDescText() {
        return null;
    }

    @Override
    protected int getEmptyImageResource() {
        return 0;
    }

    @Override
    protected View.OnClickListener getErrorButtonClickListener() {
        return null;
    }

    @Override
    protected String getErrorText() {
        return null;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public Observable<Response<List<User>>> getUsers(String pAccessToken, String pUserName) {
        return mApiInterface.getUsersFollowers(pUserName);
    }

    @Override
    public void onUsers(Response<List<User>> response) {
        if (response.code() == 200) {
            mUsersRecycAdapter.setItemClickListener(this);
            mUsersRecycAdapter.changeData(response.body());
            mRecyclerView.setAdapter(mUsersRecycAdapter);
        }
    }

    @Override
    public Observable<Response<User>> getUser(String pName) {
        return null;
    }

    @Override
    public void onUser(Response<User> response) {

    }

    @Override
    public void onInfoClick(int pPostion, User pUser, View pView) {
        Log.d("CLICK_EVENT", "on cell click");
    }

    @Override
    public void onInfoLongClick(int pPostion, User pUser, View pView) {

    }
}
