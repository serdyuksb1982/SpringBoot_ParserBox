package ru.serdyuk.parserbox.dao;

import java.util.List;

public interface ParserBoxRepository {

    ParserBoxEntity getByHash(String hash);

    List<ParserBoxEntity> getListOfPublicAndAlive(int amount);

    void add(ParserBoxEntity parserBoxEntity);
}
