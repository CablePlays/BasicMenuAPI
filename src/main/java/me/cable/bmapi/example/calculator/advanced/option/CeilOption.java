package me.cable.bmapi.example.calculator.advanced.option;

import org.jetbrains.annotations.NotNull;

public class CeilOption extends SingleNumberOperationOption {

    public CeilOption() {
        super("ceil");
    }

    @Override
    public double calculate(double num) {
        return Math.ceil(num);
    }

    @Override
    public @NotNull String format(double num, double answer) {
        return "ceil(" + num + ") = " + answer;
    }
}
