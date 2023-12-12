package com.example.spotifydemo.models;

import com.example.spotifydemo.generated.types.Playlist;
import com.example.spotifydemo.generated.types.Track;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedPlaylist extends Playlist {
    private List<MappedTrack> tracks;

    void setTracks(JsonNode jsonNode) throws IOException {
        JsonNode playlistItems = jsonNode.get("items");
        ObjectMapper mapper = new ObjectMapper();
        tracks = mapper.readValue(playlistItems.traverse(), new TypeReference<>(){});
    }

    public List<Track> getTracks() {
        //noinspection unchecked
        return (List)tracks;
    }
}