package me.cable.practice.menu.calculator.advanced.option;

import me.cable.practice.menu.option.Option;
import org.jetbrains.annotations.NotNull;

public abstract class SingleNumberOperationOption extends Option {

    public SingleNumberOperationOption(@NotNull String name) {
        super(name);
    }

    public abstract double calculate(double num);

    public abstract @NotNull String format(double num, double answer);
}
