package tech.buildrun.spotiy.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import tech.buildrun.spotiy.client.response.AlbumResponse;

@FeignClient(
        name = "AlbumSpotiyClient",
        url = "${spotify.api.uri}"
)
public interface AlbumSpotifyClient {

    @GetMapping("/v1/browse/new-releases")
    AlbumResponse getNewReleases(@RequestHeader("Authorization") String authorization);
}
