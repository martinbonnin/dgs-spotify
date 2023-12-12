package com.example.spotifydemo.models;

import com.example.spotifydemo.generated.types.Track;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MappedTrack extends Track {
}