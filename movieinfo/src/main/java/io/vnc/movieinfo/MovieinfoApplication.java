package io.vnc.movieinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieinfoApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }
}
