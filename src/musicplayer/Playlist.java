package musicplayer;

import java.util.*;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String newTitle, String password) {
        validateOwner(password);
        this.title = newTitle;
    }

    public void addMusic(Music music, String password) {
        validateOwner(password);
        if(playlist.contains(music))
            throw new InvalidOperationException("Track already in the playlist!");
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) {
        validateOwner(password);
        if(!playlist.contains(music))
            throw new InvalidOperationException("Track not found!");
        playlist.remove(music);
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<Music> result = new ArrayList<>();
        for(Music m : playlist){
            if(m.getTitle().equals(title))
                result.add(m);
        }
        return result;
    }

    public Music searchInPlaylist(String title, String singerName) {
        for(Music m : playlist){
            if(m.getTitle().equals(title) && m.getSinger().getUsername().equals(singerName))
                return m;
        }
        return null;
    }

    public void playPlaylist(User u1) {
        for(Music m : playlist)
            m.play();
    }

    private void validateOwner(String password) {
        if(!owner.getPassword().equals(password))
            throw new InvalidOperationException("You are not the owner, cant make changes.");
    }

    public ArrayList<Music> getPlaylist() {
        return playlist;
    }

    public String getTitle() {
        return this.title;
    }
}
