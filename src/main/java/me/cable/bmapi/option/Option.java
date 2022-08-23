package me.cable.bmapi.option;

import org.jetbrains.annotations.NotNull;

public class Option {

    private final String name;

    public Option(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
