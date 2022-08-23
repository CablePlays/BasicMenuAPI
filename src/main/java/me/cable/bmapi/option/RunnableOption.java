package me.cable.bmapi.option;

import org.jetbrains.annotations.NotNull;

public abstract class RunnableOption extends Option implements Runnable {

    public static @NotNull RunnableOption create(@NotNull String name, @NotNull Runnable runnable) {
        return new RunnableOption(name) {

            @Override
            public void run() {
                runnable.run();
            }
        };
    }

    public RunnableOption(@NotNull String name) {
        super(name);
    }
}
