package com.mydemo.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FriendModel implements Serializable{

    private String firstName;
    private String lsatName;

    private List<FriendsOfFriend> friendsOfFriend = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLsatName() {
        return lsatName;
    }

    public void setLsatName(String lsatName) {
        this.lsatName = lsatName;
    }
    public List<FriendsOfFriend> getFriendsOfFriend() {
        return friendsOfFriend;
    }

    public void setFriendsOfFriend(List<FriendsOfFriend> friendsOfFriend) {
        this.friendsOfFriend = friendsOfFriend;
    }

}
