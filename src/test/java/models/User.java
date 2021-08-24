package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.Objects;

public class User {
    @JsonProperty("id")
    private int id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("name")
    private String name;

    @JsonProperty("job")
    private String job;

    public User() {
    }

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withJob(String job) {
        this.job = job;
        return this;
    }

    public String toJsonString () throws IllegalAccessException {
        String res = "{";

        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = field.get(this);

            if ((fieldName == "id" && !fieldValue.equals(0)) || (fieldName != "id" && !(fieldValue == null))) {
                res += "\"" + fieldName + "\":\"" + fieldValue + "\",";
            }
        }
        res = res.substring(0, res.length() -1) + "}";
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, avatar);
    }
}
