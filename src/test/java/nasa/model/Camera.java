package nasa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Camera {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rover_id")
    private String rover_id;
    @JsonProperty("full_name")
    private String full_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return id == camera.id && name.equals(camera.name) && rover_id.equals(camera.rover_id) && full_name.equals(camera.full_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rover_id, full_name);
    }
}
