package taf.cucumber.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("properties/${env}.properties")
@ComponentScan("taf.cucumber.spring")
public class Config {

}
