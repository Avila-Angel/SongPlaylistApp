// Song class
public class Song {
    String title; // song title
    double duration; // song durations

    public Song(String title, double duration) { // constructor
        this.title = title;
        this.duration = duration;
    }
    public Song() {} // empty constructor for good practice

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() { // it will return/print class property
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
