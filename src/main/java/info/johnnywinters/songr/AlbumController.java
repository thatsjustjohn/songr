package info.johnnywinters.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;


    /////// Album Mapping ///////

    @GetMapping("/albums")
    public String getAllAlbums(Model m){
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allAlbums";
    }

    @GetMapping("/albums/new")
    public String getAddAlbumForm(){
        return "albumForm";
    }

    @GetMapping("/album/{id}/songs")
    public String getSpecficAlbum(@PathVariable long id, Model m) {
        // .get to get value inside of optional
        Album album = albumRepository.findById(id).get();
        Iterable<Song> songs = album.getSongs();
        int size = album.getSongs().size();
        m.addAttribute("songs", songs);
        return "albumSongs";
    }


    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String getSpecficAlbumByName(@RequestParam("album") String albumName, Model m) {
        // .get to get value inside of optional
        Album album = albumRepository.findByTitle(albumName).get(0);
        Iterable<Song> songs = album.getSongs();
        int size = album.getSongs().size();
        m.addAttribute("songs", songs);
        return "albumSongs";
    }

    @PostMapping("/albums")
    public RedirectView addAlbums(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl){
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    /////// Song Mapping ///////

    @GetMapping("/songs/new")
    public String getAddSongForm(){
        return "songForm";
    }

    @GetMapping("/songs")
    public String getAllSongs(Model m){
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam String title, @RequestParam int length, @RequestParam int trackNumber, @RequestParam String album) {
        List<Album> albumsWithThatName = albumRepository.findByTitle(album);
        if(albumsWithThatName.size() > 0) {
            Song song = new Song(title, length, trackNumber, albumsWithThatName.get(0));
            songRepository.save(song);
            return new RedirectView("/songs");
        } else {
            // Some error cause the album doesn't exist
            return new RedirectView("/albums/new");
        }

    }
}
