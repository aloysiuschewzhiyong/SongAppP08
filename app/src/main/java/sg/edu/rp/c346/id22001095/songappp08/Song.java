package sg.edu.rp.c346.id22001095.songappp08;

import androidx.annotation.NonNull;

public class Song {
    private int id;
    private String title;
    private String singers;
    private int year;
    private int stars;

    public Song(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;

    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getSingers() { return singers;}

    public int getYear() { return year;}

    public int getStars() {return stars;}

    @NonNull //idk how to not have this bruh
    @Override
    public String toString() {
        return id + "\n" + title
                + "\n" + singers
                + "\n" + year
                + "\n" + stars;
    }
}

