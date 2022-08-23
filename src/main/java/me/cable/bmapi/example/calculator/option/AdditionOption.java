package me.cable.bmapi.example.calculator.option;

import org.jetbrains.annotations.NotNull;

public class AdditionOption extends DoubleNumberOperationOption {

    public AdditionOption() {
        super("add");
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public @NotNull String format(double num1, double num2, double answer) {
        return num1 + " + " + num2 + " = " + answer;
    }
}
