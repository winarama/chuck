package tech.winarama.chuck.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckNorrisClient {

    private static final String uri = "https://api.chucknorris.io/jokes/random";

    private RestTemplate restTemplate;

    public ChuckNorrisClient(RestTemplateBuilder builder) {

        this.restTemplate = builder.build();
    }

    public String get() {

        return restTemplate.getForObject(uri, String.class);
    }
}
