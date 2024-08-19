package tech.buildrun.spotiy.service;

import org.springframework.stereotype.Service;
import tech.buildrun.spotiy.client.AlbumSpotifyClient;
import tech.buildrun.spotiy.client.AuthSpotifyClient;
import tech.buildrun.spotiy.client.LoginRequest;
import tech.buildrun.spotiy.client.response.Album;

import java.util.List;

@Service
public class SpotifyFeignService {
    private final LoginRequest loginRequest;
    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    public SpotifyFeignService(LoginRequest loginRequest, AuthSpotifyClient authSpotifyClient, AlbumSpotifyClient albumSpotifyClient) {
        this.loginRequest = loginRequest;
        this.authSpotifyClient = authSpotifyClient;
        this.albumSpotifyClient = albumSpotifyClient;
    }

    public List<Album> getAlbumReleases() {
        var token = authSpotifyClient.login(loginRequest).getAccessToken();
        var response = albumSpotifyClient.getNewReleases("Bearer " + token);
        return response.getAlbums().getItems();
    }
}
