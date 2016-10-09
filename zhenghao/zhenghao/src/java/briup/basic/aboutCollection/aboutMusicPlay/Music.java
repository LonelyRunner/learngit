package java.briup.basic.aboutCollection.aboutMusicPlay;

/**
 * Created by ZH on 2015/11/23.
 */
public class Music {
    private String musicName;
    private String musicMinutes;
    private String musicPlayer;

    public Music(){

    }

    public Music(String musicName, String musicMinutes, String musicPlayer) {
        this.musicName = musicName;
        this.musicMinutes = musicMinutes;
        this.musicPlayer = musicPlayer;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicMinutes() {
        return musicMinutes;
    }

    public void setMusicMinutes(String musicMinutes) {
        this.musicMinutes = musicMinutes;
    }

    public String getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(String musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicName='" + musicName + '\'' +
                ", musicMinutes='" + musicMinutes + '\'' +
                ", musicPlayer='" + musicPlayer + '\'' +
                '}';
    }
}
