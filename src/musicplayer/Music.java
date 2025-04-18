package musicplayer;

import java.util.*;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    public static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusics.add(this);
    }

    public void play() {
        numberOfStream++;
        System.out.println("Playing: " + title + " by " + singer.getUsername());
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> results = new ArrayList<>();
        for(Music m : allMusics){
            if(m.title.equals(title))
                results.add(m);
        }
        return results;
    }

    public static Music search(String title, String singerName) {
        for(Music m : allMusics){
            if(m.title.equals(title) && m.singer.getUsername().equals(singerName))
                return m;
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }
}
