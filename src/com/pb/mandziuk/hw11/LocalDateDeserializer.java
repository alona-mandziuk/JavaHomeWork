package com.pb.mandziuk.hw11;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final long serialVersionUID = 1L;
    protected LocalDateDeserializer (){
        super(LocalDate.class);
    }

    public LocalDate deserialize (JsonParser jp, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(jp.readValueAs(String.class));
    }
}
