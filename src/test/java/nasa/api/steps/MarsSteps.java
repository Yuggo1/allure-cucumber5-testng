package nasa.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.BaseStep;
import core.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import nasa.model.Photo;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@SpringBootTest(classes = {ScenarioContext.class})
public class MarsSteps extends BaseStep{

    public String marsPhotosUrl = "mars-photos/api/v1/rovers/curiosity/photos";

    @When("I request the {int} first photos made by {string} on {string}")
    public void getPhotosByDate(int numOfPics, String rover, String date) throws JsonProcessingException {
        String dt = NumberUtils.isParsable(date) ? "sol" : "earth_date";
        Map<String, String> params = new HashMap<String, String>() {{put(dt,date);}};
        if(context.map.containsKey("photos")){
            ((List<Photo[]>)context.map.get("photos")).
                    add(Arrays.copyOf(getPhotos(params,rover),numOfPics));
        }else{
            ArrayList<Photo[]> ps = new ArrayList<Photo[]>();
            ps.add(Arrays.copyOf(getPhotos(params,rover),numOfPics));
            context.map.put("photos",ps);
        }
    }

    @When("I request all photos made by {string} on {int} Mars sol")
    public void getAllPhotosByDate(String rover, int date) throws JsonProcessingException {
        Map<String, String> params = new HashMap<String, String>() {{put("sol",date+"");}};
        if(context.map.containsKey("photos")){
            ((List<Photo[]>)context.map.get("photos")).add(getPhotos(params,rover));
        }else{
            ArrayList<Photo[]> ps = new ArrayList<Photo[]>();
            ps.add(getPhotos(params,rover));
            context.map.put("photos",ps);
        }
    }

    @Then("I should get the {int} first photos made by {string} on {string}")
    public void validateApiReponse(int numOfPics,String rover, String date ) {
        Assert.assertEquals(((List<Photo[]>) context.map.get("photos")).get(0).length,numOfPics);
    }

    @Then("The responses should be equals")
    public void responsesEquals() {
        Assert.assertTrue(Arrays.equals(((List<Photo[]>) context.map.get("photos")).get(0),
                ((List<Photo[]>) context.map.get("photos")).get(1)));
    }

    @Then("No camera fired more than 10 times than the others")
    public void cameraFiredLessThan10times() {
        String fail = "";
        Photo[] photos = ((List<Photo[]>) context.map.get("photos")).get(0);
        List<String> cams = Arrays.stream(photos).map(p -> p.getCamera().getName()).distinct().collect(Collectors.toList());
        Map<String, Integer> picPerCam = new HashMap<>();
        for (String cam : cams) {
            picPerCam.put(cam,Arrays.stream(photos).filter(p -> p.getCamera().getName().equals(cam)).
                    collect(Collectors.toList()).size());
        }
        for (String cam : cams){
            for(Map.Entry<String,Integer> kv : picPerCam.entrySet()){
                if(kv.getKey().equals(cam))continue;
                if(10<picPerCam.get(cam)/kv.getValue()){
                    fail += "\r\nThe camera "+cam + " fired more than ten times than " + kv.getKey();
                }
            }
        }
        if(!fail.equals(""))Assert.fail(fail);
    }

    private Photo[] getPhotos(Map params, String rover) throws JsonProcessingException {
        Response response = given().queryParams(params).
                queryParam("api_key",System.getenv("apiKey")).
                get(baseUrl+marsPhotosUrl.replace("curiosity",rover));
        return (Photo[])response.jsonPath().getObject("photos",Photo[].class);
    }

}
