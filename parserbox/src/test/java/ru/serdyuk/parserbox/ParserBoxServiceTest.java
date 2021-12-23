package ru.serdyuk.parserbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.serdyuk.parserbox.exception.NotFoundException;
import ru.serdyuk.parserbox.service.ParserBoxService;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ParserBoxServiceTest {
    @Autowired
    private ParserBoxService parserBoxService;

    @Test
    public void notExistHash() {
        assertThrows(NotFoundException.class, () -> parserBoxService.getByHash("dsfldfsdf"));
    }
}
