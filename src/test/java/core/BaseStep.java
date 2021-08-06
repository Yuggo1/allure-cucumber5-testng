package core;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import taf.cucumber.spring.Config;

@SpringBootTest(classes = {ScenarioContext.class})
@Getter
@Component
public class BaseStep {

    @Autowired
    public ScenarioContext context;

    @Value("${url}")
    public String baseUrl;

}
