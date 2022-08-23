package me.cable.practice.menu.calculator.option;

import me.cable.practice.menu.option.Option;
import org.jetbrains.annotations.NotNull;

public abstract class DoubleNumberOperationOption extends Option {

    public DoubleNumberOperationOption(@NotNull String name) {
        super(name);
    }

    public abstract double calculate(double num1, double num2);

    public abstract @NotNull String format(double num1, double num2, double answer);
}
