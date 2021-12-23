package ru.serdyuk.parserbox.service;

import ru.serdyuk.parserbox.api.request.ParserBoxRequest;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.api.response.ParserUrlResponse;

import java.util.List;

public class ParserBoxServiceImpl implements ParserBoxService{
    @Override
    public ParserResponse getByHash(String hash) {
        return null;
    }

    @Override
    public List<ParserResponse> getFirstPublicParser(int amount) {
        return null;
    }

    @Override
    public ParserUrlResponse create(ParserBoxRequest request) {
        return null;
    }
}
