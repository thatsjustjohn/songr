package info.johnnywinters.songr;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album album;

    String title;
    int length;
    int trackNumber;

    public Song(){};

    public Song(String title, int length, int trackNumber, Album album){
        this.album = album;
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return this.album;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return this.length;
    }

    public int getTrackNumber(){
        return this.trackNumber;
    }
}


