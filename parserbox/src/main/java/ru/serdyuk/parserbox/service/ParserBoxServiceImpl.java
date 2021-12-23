package ru.serdyuk.parserbox.service;

import org.springframework.stereotype.Service;
import ru.serdyuk.parserbox.api.request.ParserBoxRequest;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.api.response.ParserUrlResponse;
import ru.serdyuk.parserbox.dao.ParserBoxRepository;

import java.util.List;

@Service

public class ParserBoxServiceImpl implements ParserBoxService{

    private final ParserBoxRepository repository;

    public ParserBoxServiceImpl(ParserBoxRepository repository) {
        this.repository = repository;
    }

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
