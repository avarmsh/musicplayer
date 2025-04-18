package musicplayer;

import java.util.*;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> following = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        if (password.length() < 8)
            throw new InvalidOperationException("Passwords should consist of 8 characters or more.");
        for (User u : allUsers) {
            if (u.getUsername().equals(username))
                throw new InvalidOperationException("This username already has an account.");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow(User user) {
        if (!following.contains(user)) {
            following.add(user);
            user.followers.add(this);
        }
    }

    public void createPlaylist(String title) {
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(int month) {
        this.behavior.buyPremium(this, month);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<User> getFollowing() {
        return this.following;
    }
    public ArrayList<User> getFollowers() {
        return this.followers;
    }
}

