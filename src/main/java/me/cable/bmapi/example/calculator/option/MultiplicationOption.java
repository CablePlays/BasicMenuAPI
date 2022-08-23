package me.cable.bmapi.example.calculator.option;

import org.jetbrains.annotations.NotNull;

public class MultiplicationOption extends DoubleNumberOperationOption {

    public MultiplicationOption() {
        super("mul");
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public @NotNull String format(double num1, double num2, double answer) {
        return num1 + " * " + num2 + " = " + answer;
    }
}
