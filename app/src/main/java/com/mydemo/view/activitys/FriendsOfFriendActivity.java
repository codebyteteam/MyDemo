package com.mydemo.view.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mydemo.Model.FriendsOfFriend;
import com.mydemo.R;
import com.mydemo.adapter.FriendOfFriendAdapter;
import com.mydemo.common.MyDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FriendsOfFriendActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_friend_list)
    RecyclerView rvFriendList;
    @BindView(R.id.tv_back)
    TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_of_friend);
        ButterKnife.bind(this);

        List<FriendsOfFriend> arrayFriendOfFriend = (List<FriendsOfFriend>) getIntent().getSerializableExtra("friendOfFriend");

        RecyclerView.LayoutManager linearLayoutNamager = new LinearLayoutManager(FriendsOfFriendActivity.this, LinearLayout.VERTICAL, false);
        rvFriendList.setLayoutManager(linearLayoutNamager);
        rvFriendList.setHasFixedSize(true);
        rvFriendList.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 5));

        FriendOfFriendAdapter mFriendOfFriendAdapter = new FriendOfFriendAdapter(arrayFriendOfFriend);
        rvFriendList.setAdapter(mFriendOfFriendAdapter);

    }

    @OnClick(R.id.tv_back)
    public void onViewClicked() {

        onBackPressed();
    }
}
