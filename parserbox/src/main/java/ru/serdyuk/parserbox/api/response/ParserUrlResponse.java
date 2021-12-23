package ru.serdyuk.parserbox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParserUrlResponse {
    private final String url;

}
