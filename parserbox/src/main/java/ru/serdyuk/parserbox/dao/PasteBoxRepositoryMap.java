package ru.serdyuk.parserbox.dao;

import java.util.List;

public class PasteBoxRepositoryMap implements ParserBoxRepository{
    @Override
    public ParserBoxEntity getByHash(String hash) {
        return null;
    }

    @Override
    public List<ParserBoxEntity> getListOfPublicAndAlive(int amount) {
        return null;
    }

    @Override
    public ParserBoxEntity add(ParserBoxEntity parserBoxEntity) {
        return null;
    }
}
