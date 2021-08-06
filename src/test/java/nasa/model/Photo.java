package nasa.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;
import java.util.Objects;

@Getter
public class Photo {

    @JsonProperty("id")
    private int id;
    @JsonProperty("sol")
    private int sol;
    @JsonProperty("camera")
    private Camera camera;
    @JsonProperty("img_src")
    private String img_src;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("earth_date")
    private Date earth_date;
    @JsonProperty("rover")
    private Rover rover;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id && sol == photo.sol && camera.equals(photo.camera) && img_src.equals(photo.img_src) && earth_date.equals(photo.earth_date) && rover.equals(photo.rover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sol, camera, img_src, earth_date, rover);
    }
}
