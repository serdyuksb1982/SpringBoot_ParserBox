package ru.serdyuk.parserbox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ParserResponse {
    private final String data;

    private final boolean isPublic;

}
