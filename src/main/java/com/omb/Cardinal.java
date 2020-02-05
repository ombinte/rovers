package com.omb;

import java.util.Optional;
import java.util.stream.Stream;

public enum Cardinal {
    NORTH("N"), SOUTH("S"), EST("E"), WEST("W");

    private String code;

    Cardinal(String code) {
        this.code = code;
    }

    public static Cardinal getFromCode(String code) {

        Optional<Cardinal> optional =
                Stream.of(Cardinal.values()).filter(c ->c.getCode().equals(code)).findFirst();
        if(!optional.isPresent()) {
            throw new IllegalStateException(String.format("Unsupported type " +
                    "%s.", code));
        }

        return optional.get();
    }

    public String getCode() {
        return code;
    }
}
