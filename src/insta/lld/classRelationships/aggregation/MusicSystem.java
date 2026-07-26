package insta.lld.classRelationships.aggregation;

import java.util.ArrayList;
import java.util.List;

class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.songs.addAll(songs);
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public List<Song> getSongs() {
        return this.songs;
    }

    public String getName() {
        return this.name;
    }
}

class Song {
    private String name;
    private Artist artist;
    private int duration;

    public Song(String name, Artist artist, int duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public Artist getArtist() {
        return this.artist;
    }

}

class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class MusicSystem {
    public static void main(String[] args) {
        Song teraFitoor = new Song("Tera Fitoor", new Artist("Arijit Singh"), 4);
        Song tumHiHo = new Song("Tum hi ho", new Artist("Arijit Singh"), 5);

        Playlist arijitTopHits = new Playlist("Arijit top hits", List.of(teraFitoor, tumHiHo));

        System.out.println(arijitTopHits.getSongs().stream().map(Song::getName).toList());
    }
}
