package ru.serdyuk.parserbox.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.serdyuk.parserbox.api.request.ParserBoxRequest;
import ru.serdyuk.parserbox.api.request.PublicStatus;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.api.response.ParserUrlResponse;
import ru.serdyuk.parserbox.dao.ParserBoxEntity;
import ru.serdyuk.parserbox.dao.ParserBoxRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
@Setter
public class ParserBoxServiceImpl implements ParserBoxService{
    private final ParserBoxRepository repository;
    private String host;
    private int publicIntSize;


    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public ParserResponse getByHash(String hash) {
        ParserBoxEntity parserBoxEntity = repository.getByHash(hash);

        return new ParserResponse(parserBoxEntity.getData(), parserBoxEntity.isPublic());
    }

    @Override
    public List<ParserResponse> getFirstPublicParser() {
        List<ParserBoxEntity> list = repository.getListOfPublicAndAlive(publicIntSize);
        return list.stream().map(parserBoxEntity ->
                new ParserResponse(parserBoxEntity.getData(),parserBoxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public ParserUrlResponse create(ParserBoxRequest request) {
        int hash = generateId();
        ParserBoxEntity parserBoxEntity = new ParserBoxEntity();
        parserBoxEntity.setData(request.getData());
        parserBoxEntity.setId(hash);
        parserBoxEntity.setHash(Integer.toHexString(hash));
        parserBoxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        parserBoxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.add(parserBoxEntity);
        return new ParserUrlResponse(host + "/" + parserBoxEntity.getHash());
    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}
