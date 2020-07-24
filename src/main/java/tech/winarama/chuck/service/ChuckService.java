package tech.winarama.chuck.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.winarama.chuck.client.ChuckNorrisClient;
import tech.winarama.chuck.client.SentimentAnalysisClient;
import tech.winarama.chuck.domain.ChuckResult;

@Service
public class ChuckService {

    @Autowired
    private ChuckNorrisClient chuckNorrisClient;

    @Autowired
    private SentimentAnalysisClient sentimentAnalysisClient;

    @SneakyThrows(JsonProcessingException.class)
    @HystrixCommand(fallbackMethod = "fallback")
    public ChuckResult execute() {

        //  Get random Chuck Norris fact
        String randomChuckNorrisFact = chuckNorrisClient.get();

        //  Run sentiment analysis
        JsonNode sentiment = sentimentAnalysisClient.post(randomChuckNorrisFact);

        return ChuckResult
                .builder()
                .randomFact(randomChuckNorrisFact)
                .sentiment(formatText(sentiment.get("label").textValue()))
                .build();
    }

    private String formatText(String text) {
        String formatted = text;

        switch (text) {
            case "pos":
                formatted = "positive";
                break;
            case "neg" :
                formatted = "negative";
                break;
            default:
                formatted = "neutral";
                break;
        }

        return formatted;
    }

    public ChuckResult fallback() {
        return ChuckResult
                .builder()
                .randomFact("Chuck Norris once round-house kicked a man in a call centre. Over the phone.")
                .sentiment("neutral")
                .build();
    }
}
