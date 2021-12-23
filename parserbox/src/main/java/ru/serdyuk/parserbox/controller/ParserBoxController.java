package ru.serdyuk.parserbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.serdyuk.parserbox.api.request.ParserBoxRequest;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.api.response.ParserUrlResponse;
import ru.serdyuk.parserbox.service.ParserBoxService;
import java.util.Collection;


/**
 * Simple controller
 */
@RestController
@RequiredArgsConstructor
public class ParserBoxController {
    private final ParserBoxService parserBoxService;

    @GetMapping("/")
    public Collection<ParserResponse> getPublicParserList() {
        return parserBoxService.getFirstPublicParser();
    }

    @GetMapping("/{hash}")
    public ParserResponse getByHash(@PathVariable String hash) {
        return parserBoxService.getByHash(hash);
    }

    @PostMapping("/")
    public ParserUrlResponse add(@RequestBody ParserBoxRequest request) {
        return parserBoxService.create(request);
    }
}
