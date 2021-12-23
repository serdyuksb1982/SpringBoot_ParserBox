package ru.serdyuk.parserbox.dao;

import org.springframework.stereotype.Repository;
import ru.serdyuk.parserbox.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * получает список, ищет и возвращает
 */
@Repository
public class PasteBoxRepositoryMap implements ParserBoxRepository{

    private final Map<String,ParserBoxEntity> values = new ConcurrentHashMap<>();

    @Override
    public ParserBoxEntity getByHash(String hash) {
        ParserBoxEntity parserBoxEntity = values.get(hash);
        if(parserBoxEntity == null) {
            throw new NotFoundException("ParserBox not found wish hash=" + hash);
        }
        return parserBoxEntity;
    }

    @Override
    public List<ParserBoxEntity> getListOfPublicAndAlive(int amount) {
        LocalDateTime now = LocalDateTime.now();

        return values.values().stream()
                .filter(ParserBoxEntity::isPublic)
                .filter(parserBoxEntity -> parserBoxEntity.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(ParserBoxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());

    }

    @Override
    public void add(ParserBoxEntity parserBoxEntity) {

        values.put(parserBoxEntity.getHash(),parserBoxEntity);
    }
}
