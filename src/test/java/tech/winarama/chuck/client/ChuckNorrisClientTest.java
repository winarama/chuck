package tech.winarama.chuck.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ChuckNorrisClientTest {

    @Autowired
    private ChuckNorrisClient api;

    @Test
    public void get() {
        String data = api.get();
        assertNotNull(data);
    }
}
