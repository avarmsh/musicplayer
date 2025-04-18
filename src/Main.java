import musicplayer.*;

public class Main {
    public static void main(String[] args) {
        try {
            User u1 = new User("Ava", "12345678");
            User u2 = new User("Diba", "87654321");
            User u3 = new User("Ermi", "23456781");

            Music m1 = new Music("Faith", u1);
            Music m2 = new Music("Afterhours", u1);
            Music m3 = new Music("Faith", u2);
            Music m4 = new Music("Creepin", u2);
            Music m5 = new Music("Timeless", u2);
            Music m6 = new Music("Blindinglights", u2);
            Music m7 = new Music("Heartless", u2);
            Music m8 = new Music("Often", u2);

            System.out.println("\n Playing musics (before premium)");
            try { u1.playMusic(m1); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }
            try { u1.playMusic(m2); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }
            try { u1.playMusic(m3); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }
            try { u1.playMusic(m4); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }
            try { u1.playMusic(m5); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }

            u1.buyPremium(3);
            u2.buyPremium(1);

            System.out.println("\n Playing musics (after premium) ");
            try { u1.playMusic(m6); } catch (InvalidOperationException e) { System.err.println(e.getMessage()); }

            System.out.println("\n Creating Playlist ");
            u2.createPlaylist("Diba's fav tracks");
            Playlist myPlaylist = u2.getPlaylists().get(0);
            System.out.println("Playlist title: " + myPlaylist.getTitle());

            String correctPassword = "87654321";
            Music[] musicsToAdd = { m1, m2, m3, m4, m5, m6, m7 };
            for(Music m : musicsToAdd){
                try {
                    myPlaylist.addMusic(m, correctPassword);
                }catch(InvalidOperationException e) {
                    System.err.println("Could not add " + m.getTitle() + ": " + e.getMessage());
                }
            }

            System.out.println("\n Playlist Contents ");
            for(Music m : myPlaylist.getPlaylist()){
                System.out.println("- " + m.getTitle());
            }

            System.out.println("\n Searching for 'Faith' ");
            for(Music m : Music.search("Faith")){
                System.out.println(m.getTitle() + " by " + m.getSinger().getUsername());
            }

            System.out.println("\n Playing Playlist");
            myPlaylist.playPlaylist(u2);

            System.out.println("\n Following Users");
            u1.follow(u2);
            u1.follow(u3);
            u2.follow(u1);

            System.out.println("\nu1 is following:");
            for(User u : u1.getFollowing()){
                System.out.println("- " + u.getUsername());
            }

            System.out.println("\nu1 followers:");
            for(User u : u1.getFollowers()){
                System.out.println("- " + u.getUsername());
            }

            System.out.println("\n Stream Counts ");
            System.out.println(m1.getTitle() + " has been streamed " + m1.getNumberOfStream() + " times.");

        } catch(InvalidOperationException e){
            System.err.println("Critical Error: " + e.getMessage());
        }
    }
}
