package xyz.vegaone.scribe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.vegaone.scribe.service.ScribeService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/filediscovery")
public class ScribeController {

    private ScribeService scribeService;

    @Autowired
    public ScribeController(ScribeService scribeService) {
        this.scribeService = scribeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, List<String>> createScribe(String path) throws IOException {
        Map<String, List<String>> savedScribe = scribeService.discoverAndIndexFiles(path);

        return savedScribe;
    }
}
