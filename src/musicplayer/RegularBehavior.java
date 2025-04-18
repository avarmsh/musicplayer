package musicplayer;

public class RegularBehavior implements UserBehavior {
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String title, User owner) {
        throw new InvalidOperationException("Regular accounts can't create playlists!");
    }

    @Override
    public void playMusic(Music music) {
        if(playingLimit <= 0)
            throw new InvalidOperationException("You have reached playing limit.");
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
