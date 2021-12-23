package ru.serdyuk.parserbox.service;

import ru.serdyuk.parserbox.api.request.ParserBoxRequest;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.api.response.ParserUrlResponse;

import java.util.List;

public interface ParserBoxService {
    ParserResponse getByHash(String hash);
    List<ParserResponse> getFirstPublicParser();
    ParserUrlResponse create(ParserBoxRequest request);
}
