package nasa.api.steps;

import taf.cucumber.spring.Config;
import core.ScenarioContext;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.test.context.ContextConfiguration;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "classpath:core", "classpath:nasa" },
        plugin = {
            "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
            "progress",
            "summary"
        }
)

@CucumberContextConfiguration
@ContextConfiguration( classes = { ScenarioContext.class, Config.class})
public class CucumberTest extends AbstractTestNGCucumberTests {

}
