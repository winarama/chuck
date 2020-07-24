package tech.winarama.chuck.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.winarama.chuck.domain.ChuckResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ChuckServiceTest {

    @Autowired
    private ChuckService chuckService;

    @Test
    public void execute() throws JsonProcessingException {
        ChuckResult result = chuckService.execute();
        assertNotNull(result);
    }
}
