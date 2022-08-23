package me.cable.practice.menu.calculator.advanced.option;

import org.jetbrains.annotations.NotNull;

public class SquareOption extends SingleNumberOperationOption {

    public SquareOption() {
        super("square");
    }

    @Override
    public double calculate(double num) {
        return num * num;
    }

    @Override
    public @NotNull String format(double num, double answer) {
        return num + " * " + num + " = " + answer;
    }
}
