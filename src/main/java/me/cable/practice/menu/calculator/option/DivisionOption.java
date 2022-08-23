package me.cable.practice.menu.calculator.option;

import org.jetbrains.annotations.NotNull;

public class DivisionOption extends DoubleNumberOperationOption {

    public DivisionOption() {
        super("div");
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public @NotNull String format(double num1, double num2, double answer) {
        return num1 + " / " + num2 + " = " + answer;
    }
}
