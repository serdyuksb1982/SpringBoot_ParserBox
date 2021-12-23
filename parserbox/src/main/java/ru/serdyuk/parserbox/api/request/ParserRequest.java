package ru.serdyuk.parserbox.api.request;

import lombok.Data;

@Data
public class ParserRequest {

    private String data;

    private long expirationTimeSeconds;

    private PublicStatus publicStatus;

}
