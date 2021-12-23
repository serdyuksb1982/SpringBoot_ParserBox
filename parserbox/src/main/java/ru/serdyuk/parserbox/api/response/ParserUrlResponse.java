package ru.serdyuk.parserbox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Setter
public class ParserUrlResponse {
    private final String url;

}
