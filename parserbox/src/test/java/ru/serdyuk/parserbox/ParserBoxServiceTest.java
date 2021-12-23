package ru.serdyuk.parserbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.serdyuk.parserbox.api.response.ParserResponse;
import ru.serdyuk.parserbox.dao.ParserBoxEntity;
import ru.serdyuk.parserbox.dao.ParserBoxRepository;
import ru.serdyuk.parserbox.exception.NotFoundException;
import ru.serdyuk.parserbox.service.ParserBoxService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ParserBoxServiceTest {
    @Autowired
    private ParserBoxService parserBoxService;

    @MockBean
    private ParserBoxRepository parserBoxRepository;

    @Test
    public void notExistHash() {
        assertThrows(NotFoundException.class, () -> parserBoxService.getByHash("dsfldfsdf"));
    }

    @Test
    public void getExistsHash() {
        ParserBoxEntity entity = new ParserBoxEntity();
        entity.setHash("1");
        entity.setData("11");
        entity.setPublic(true);

        when(parserBoxRepository.getByHash("1")).thenReturn(entity);

        ParserResponse expected = new ParserResponse("11",true);
        ParserResponse actual = parserBoxService.getByHash("1");
        assertEquals(expected,actual);
    }
}
