package nasa.apiutils;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class MarsRoverPhotosApi {

    private String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/" +
            "photos?sol=1000&api_key=r5NitMOHTaGOchXoEPRhPA2GCbf8PUzpSILOdwwA";

    public void getCuriosityPhotos(String date, String camera, String page){
    }
}
