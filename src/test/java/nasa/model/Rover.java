package nasa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Rover {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("landing_date")
    private Date landing_date;
    @JsonProperty("launch_date")
    private Date launch_date;
    @JsonProperty("status")
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return id == rover.id && Objects.equals(name, rover.name) && Objects.equals(landing_date, rover.landing_date) && Objects.equals(launch_date, rover.launch_date) && Objects.equals(status, rover.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, landing_date, launch_date, status);
    }
}
