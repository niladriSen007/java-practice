package designPatterns.behavioural.iterator;

public class MusicPlayer {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        playlist.addSong("Tum hi ho");
        playlist.addSong("Sande se");

        Iterator<String> it = playlist.getIterator();

        while (it.hasNext()) {
            System.out.println(" 🎵 " + it.next());
        }
    }
}
