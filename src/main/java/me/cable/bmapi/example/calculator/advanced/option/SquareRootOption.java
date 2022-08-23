package me.cable.bmapi.example.calculator.advanced.option;

import org.jetbrains.annotations.NotNull;

public class SquareRootOption extends SingleNumberOperationOption {

    public SquareRootOption() {
        super("sqrt");
    }

    @Override
    public double calculate(double num) {
        return Math.sqrt(num);
    }

    @Override
    public @NotNull String format(double num, double answer) {
        return "sqrt(" + num + ") = " + answer;
    }
}
