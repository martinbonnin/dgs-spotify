package com.example.spotifydemo.datasources;

import com.example.spotifydemo.generated.types.Playlist;
import com.example.spotifydemo.models.MappedPlaylists;
import com.example.spotifydemo.models.MappedPlaylist;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class SpotifyClient {
    private static final String SPOTIFY_API_URL = "https://spotify-demo-api-fe224840a08c.herokuapp.com/v1";
    private final WebClient builder = WebClient.builder().baseUrl(SPOTIFY_API_URL).build();

    public List<MappedPlaylist> featuredPlaylistsRequest() {
        return builder
                .get()
                .uri("/browse/featured-playlists")
                .retrieve()
                .bodyToMono(MappedPlaylists.class)
                .block()
                .getPlaylists();
    }

    public MappedPlaylist playlistRequest(String playlistId) {
        return builder
                .get()
                .uri("/playlists/{playlist_id}", playlistId)
                .retrieve()
                .bodyToMono(MappedPlaylist.class)
                .block();
    }
}