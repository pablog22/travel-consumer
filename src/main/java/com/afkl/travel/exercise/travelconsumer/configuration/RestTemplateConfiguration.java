package com.afkl.travel.exercise.travelconsumer.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        //builder.basicAuthentication("someuser", "{noop}psw");
        RestTemplate restTemplate = builder.build();
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("someuser", "psw"));
        return restTemplate;
    }
}
