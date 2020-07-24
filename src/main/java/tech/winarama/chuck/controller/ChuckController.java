package tech.winarama.chuck.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.winarama.chuck.domain.ChuckResult;
import tech.winarama.chuck.service.ChuckService;

@RestController
@RequestMapping("/api")
public class ChuckController {

    @Autowired
    private ChuckService chuckService;

    @RequestMapping(value = "/execute",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuckResult execute() {
        return chuckService.execute();
    }
}
