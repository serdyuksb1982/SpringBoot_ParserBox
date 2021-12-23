package ru.serdyuk.parserbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /*@PostMapping("/")
    public String add()*/
}
