package core;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ScenarioContext {

    public HashMap<String, Object> map;

    public void reset(){
        map = new HashMap<>();
    }

}
