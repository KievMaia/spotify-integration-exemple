package tech.buildrun.spotiy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.spotiy.client.response.Album;
import tech.buildrun.spotiy.service.SpotifyFeignService;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
public class AlbumController {
    private final SpotifyFeignService service;

    public AlbumController(SpotifyFeignService service) {
        this.service = service;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> helloWorld() {
        return ResponseEntity.ok(service.getAlbumReleases());
    }
}
