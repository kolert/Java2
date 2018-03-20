package lv.javaguru.java2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class DatabaseConfig {

    @Value("${url}")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}