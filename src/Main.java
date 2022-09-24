import java.util.*;

public class Main {

    private static final ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        // create album object
        Album album = new Album("Un Verano Sin Ti","Bad Bunny");

        // add songs to album
        album.addSong("Efecto", 3.50);
        album.addSong("Un Coco", 3.25);
        album.addSong("Party", 3.75);
        album.addSong("Agosto", 2.33);
        album.addSong("Tarot", 4.00);
        album.addSong("Moscow Mule", 4.12);
        albums.add(album); // add album to Arraylist

        // create new album
        album = new Album("Certified Lover Boy", "Drake");

        // add songs to album
        album.addSong("In the Bible", 4.90);
        album.addSong("Fountains", 3.17);
        album.addSong("Knife Talk", 4.00);
        album.addSong("Fair Trade", 4.90);
        album.addSong("Love All", 3.90);
        albums.add(album); // add album to Arraylist

        // Linklist of playlist which will contain the songs from both albums
        LinkedList<Song> playList_1 = new LinkedList<>();

        // add songs to Playlist
        albums.get(0).addToPlaylist("Efecto", playList_1); // adds Efecto to Playlist
        albums.get(0).addToPlaylist("Party", playList_1); // adds Party to Playlist
        albums.get(1).addToPlaylist("Knife Talk", playList_1); // adds Knife Talk to Playlist
        albums.get(1).addToPlaylist("Fair Trade", playList_1); // adds Fair Trade to Playlist

        // method to play songs
        play(playList_1);
    }

    // method to play songs
    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        // checks to see if playlist is empty
        if(playList.size() == 0) { // if playlist doesn't have any songs
            System.out.println("This playlist has no songs");
        } else { // if playlist has songs
            System.out.println("Now playing " + listIterator.next().toString()); // prints current song
            printMenu(); // shows user available menu options
        }
        while(!quit) { // while the user has not quit yet
            // take user input
            int action = scan.nextInt();

            // define all cases for user input
            switch(action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("No song available, reached to end of the list");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the first song");
                    }
                    break;

                case 3:
                    if(forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }

    // methods for user interactions

    private static void printMenu() {
        System.out.println("Available options\n press");
        System.out.println("""
                0 - to quit
                1 - to play next song
                2 - to play previous song
                3 - to replay current song
                5 - print all available options
                6 - delete current song""");
    }
    // method to print list
    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("--------------------");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------------");
    }
}