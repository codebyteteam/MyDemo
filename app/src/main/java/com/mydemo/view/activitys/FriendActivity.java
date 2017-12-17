package com.mydemo.view.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mydemo.Model.FriendModel;
import com.mydemo.Model.FriendsOfFriend;
import com.mydemo.R;
import com.mydemo.adapter.FriendAdapter;
import com.mydemo.common.ClickListener;
import com.mydemo.common.MyDividerItemDecoration;
import com.mydemo.common.RecyclerTouchListener;
import com.mydemo.common.SharePref;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendActivity extends AppCompatActivity {

    @BindView(R.id.rv_friend_list)
    RecyclerView rvFriendList;
    @BindView(R.id.tv_logout)
    TextView tvLogout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<FriendModel> arrayFriend = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager linearLayoutNamager = new LinearLayoutManager(FriendActivity.this, LinearLayout.VERTICAL, false);
        rvFriendList.setLayoutManager(linearLayoutNamager);
        rvFriendList.setHasFixedSize(true);
        rvFriendList.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 5));

        for (int i = 0; i < 10; i++) {
            FriendModel friendModel = new FriendModel();
            friendModel.setFirstName("First Name : " + String.valueOf(i));
            friendModel.setLsatName("Last Name : " + String.valueOf(i));
            List<FriendsOfFriend> arrayFriendOfFriend = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                FriendsOfFriend mFriendsOfFriend = new FriendsOfFriend();
                mFriendsOfFriend.setFirstName("Friedns of Friend First Name : " + String.valueOf(j));
                mFriendsOfFriend.setLastName("Friedns of Friend Last Name : " + String.valueOf(j));
                arrayFriendOfFriend.add(mFriendsOfFriend);
                friendModel.setFriendsOfFriend(arrayFriendOfFriend);
            }
            arrayFriend.add(friendModel);
        }

        FriendAdapter mAdapter = new FriendAdapter(arrayFriend);
        rvFriendList.setAdapter(mAdapter);
        rvFriendList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvFriendList, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intNext = new Intent(FriendActivity.this, FriendsOfFriendActivity.class);
                intNext.putExtra("friendOfFriend", (Serializable) arrayFriend.get(position).getFriendsOfFriend());
                startActivity(intNext);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @OnClick(R.id.tv_logout)
    public void onViewClicked() {

        SharePref mSharePref = new SharePref(FriendActivity.this);
        mSharePref.setUserIdToPref("");

        Intent intentNext = new Intent(FriendActivity.this, MainActivity.class);
        intentNext.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentNext);

    }
}
