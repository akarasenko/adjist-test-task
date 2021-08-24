package models.getSingleUserResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.User;

public class SingleUserResponse {
    @JsonProperty("data")
    private User data;

    @JsonProperty("support")
    private Support support;

    public SingleUserResponse(){
    }

    public User getUserFromResponse (){
        return this.data;
    }
}
