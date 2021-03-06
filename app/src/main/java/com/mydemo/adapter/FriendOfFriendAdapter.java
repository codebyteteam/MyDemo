package com.mydemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mydemo.Model.FriendModel;
import com.mydemo.Model.FriendsOfFriend;
import com.mydemo.R;

import java.util.List;


public class FriendOfFriendAdapter extends RecyclerView.Adapter<FriendOfFriendAdapter.MyViewHolder> {

    private List<FriendsOfFriend> arrayFriend;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView first_name,last_name;

        public MyViewHolder(View view) {
            super(view);
            first_name = (TextView) view.findViewById(R.id.first_name);
            last_name = (TextView) view.findViewById(R.id.last_name);
        }
    }

    public FriendOfFriendAdapter(List<FriendsOfFriend> moviesList) {
        this.arrayFriend = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FriendsOfFriend friend = arrayFriend.get(position);
        holder.first_name.setText(friend.getFirstName());
        holder.last_name.setText(friend.getLastName());

    }

    @Override
    public int getItemCount() {
        return arrayFriend.size();
    }
}