package com.example.spotifydemo.models;

import com.example.spotifydemo.generated.types.Playlist;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class MappedPlaylists {
    private List<MappedPlaylist> playlists;

    public void setPlaylists(JsonNode jsonNode) throws IOException {
        JsonNode playlistItems = jsonNode.get("items");
        ObjectMapper mapper = new ObjectMapper();
        playlists = mapper.readValue(playlistItems.traverse(), new TypeReference<>(){});
    }

    public List<MappedPlaylist> getPlaylists() {
        return playlists;
    }
}
