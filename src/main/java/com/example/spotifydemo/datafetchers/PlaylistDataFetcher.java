package com.example.spotifydemo.datafetchers;

import com.example.spotifydemo.datasources.SpotifyClient;
import com.example.spotifydemo.generated.types.Playlist;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.example.spotifydemo.models.MappedPlaylist;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class PlaylistDataFetcher {
    private final SpotifyClient spotifyClient;

    @Autowired
    public PlaylistDataFetcher(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }

    @DgsQuery
    public List<MappedPlaylist> featuredPlaylists() {
        return spotifyClient.featuredPlaylistsRequest();
    }

    @DgsQuery
    public Playlist playlist(@InputArgument String id) {
        return spotifyClient.playlistRequest(id);
    }

}