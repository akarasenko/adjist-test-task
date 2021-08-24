package models.getSingleUserResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Support {
    @JsonProperty("url")
    private String url;

    @JsonProperty("text")
    private String text;

    public Support() {
    }
}
