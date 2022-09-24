// Album class

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) { // constructor
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {} // empty constructor for good practice

    // method to check whether song is already in album or not
    public Song findSong(String title) { // will iterate through album to check if there is a duplicate song
        for(Song checkedSong : songs) {
            if(checkedSong.getTitle().equals(title)) return checkedSong; // if song exists in album, it will return song
        }
            return null; // if song doesn't exist in album, return null
    }

    // method to add song if it doesn't exist or to let user know if song already exists in album
    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) { // if song doesn't exist in album, add song
            songs.add(new Song(title, duration));
            // System.out.println(title + " successfully added to list");
            return true;
        } else { // if song does exist in album, print statement
            // System.out.println("Song with name " + title + " already exist in the list");
            return false;
        }
    }

    // functionality to add song to playlist, this song must be in our added list already
    // adds song that's present in the album to playlist
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist) {
        int index = trackNumber - 1; // remember it starts at 0
        if(index > 0 && index <= this.songs.size()) {
            Playlist.add(this.songs.get(index));
            return true;
        }
        // System.out.println("This album does not have song with tracknumber " + trackNumber);
        return false;
    }
    // similar to previous method, but takes different parameters
    public boolean addToPlaylist(String title, LinkedList<Song> Playlist) {
        for(Song checkedSong : this.songs) {
            if(checkedSong.getTitle().equals(title)) {
                Playlist.add(checkedSong);
                return true;
            }
        }
        // System.out.println("There is no such song in album");
        return false;
    }

}
