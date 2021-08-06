package core;

import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import taf.cucumber.spring.Config;

@SpringBootTest(classes = {ScenarioContext.class, Config.class})
public class Setup {

    @Autowired
    private ScenarioContext context;
    @Value("${url}")
    public  String url;

    @Before
    public void contextSetup(){
        context.reset();
    }
}
