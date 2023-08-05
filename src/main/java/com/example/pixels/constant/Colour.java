package com.example.pixels.constant;

import lombok.Getter;

@Getter
public enum Colour {
    BLACK(1),
    RED(2),
    GREEN(3),
    BLUE(4),
    WHITE(5),
    YELLOW(6),
    ORANGE(7);

    private final int code;

    Colour(int code) {
        this.code = code;
    }

}
