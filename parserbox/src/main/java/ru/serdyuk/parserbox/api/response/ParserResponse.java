package ru.serdyuk.parserbox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@RequiredArgsConstructor
@Setter
public class ParserResponse {
    private final String data;

    private final boolean isPublic;

}
