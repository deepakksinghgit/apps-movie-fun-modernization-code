package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }


    @GetMapping
    public List<Album> list() {
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{albumId}")
    public Album details(@PathVariable long albumId) {
        return albumsRepository.find(albumId);
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }
}
