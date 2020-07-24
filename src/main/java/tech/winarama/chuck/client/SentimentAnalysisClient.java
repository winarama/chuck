package tech.winarama.chuck.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SentimentAnalysisClient {

    private static final String uri = "http://text-processing.com/api/sentiment/";

    private RestTemplate restTemplate;
    private HttpHeaders headers;

    public SentimentAnalysisClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    }

    public JsonNode post(String text) throws JsonProcessingException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("text", text);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

        JsonNode productNode = new ObjectMapper().readTree(response.getBody());

        return productNode;
    }
}
