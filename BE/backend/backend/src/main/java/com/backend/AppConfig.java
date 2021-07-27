package com.backend;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        excludeFilters =@ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = {Configuration.class, Controller.class})
)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfig {
}
