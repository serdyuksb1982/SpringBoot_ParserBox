package ru.serdyuk.parserbox.api.response;

import lombok.Data;
import ru.serdyuk.parserbox.api.request.PublicStatus;

@Data
public class ParserResponse {
    private String data;

    private PublicStatus status;


}
