package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("id")
    private int id;

    public User getUserFromResponse () {
        return new User().withName(this.name).withJob(this.job).withId(this.id);
    }
}
