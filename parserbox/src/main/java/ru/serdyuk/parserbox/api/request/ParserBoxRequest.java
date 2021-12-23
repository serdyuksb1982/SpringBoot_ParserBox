package ru.serdyuk.parserbox.api.request;

import lombok.Data;

@Data
public class ParserBoxRequest {

    private String data;

    private long expirationTimeSeconds;

    private PublicStatus publicStatus;

}
