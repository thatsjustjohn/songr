package info.johnnywinters.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

    @OneToMany(mappedBy = "album")
    List<Song> Songs;

    public Album() {}

    public Album(String title, String artist, int songCount, int length, String imageUrl){
       this.title = title;
       this.artist = artist;
       this.songCount = songCount;
       this.length = length;
       this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
