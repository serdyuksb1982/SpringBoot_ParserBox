package ru.serdyuk.parserbox.controller;

import org.springframework.web.bind.annotation.*;
import ru.serdyuk.parserbox.api.request.ParserRequest;

import java.util.Collection;
import java.util.Collections;

/**
 * Simple controller
 */
@RestController
public class ParserBoxController {

    @GetMapping("/")
    public Collection<String> getPublicParserList() {
        return Collections.emptyList();
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash) {
        return hash;
    }

    @PostMapping("/")
    public String add(@RequestBody ParserRequest request) {
        return request.getData();
    }
}
