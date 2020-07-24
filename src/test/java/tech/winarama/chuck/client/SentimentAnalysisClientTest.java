package tech.winarama.chuck.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SentimentAnalysisClientTest {

    @Autowired
    private SentimentAnalysisClient api;

    @Test
    public void post() throws JsonProcessingException {
        JsonNode data = api.post("sunshine, lollipops and rainbows, everywhere!");
        assertNotNull(data);
    }
}
