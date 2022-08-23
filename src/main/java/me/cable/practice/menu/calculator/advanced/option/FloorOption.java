package me.cable.practice.menu.calculator.advanced.option;

import org.jetbrains.annotations.NotNull;

public class FloorOption extends SingleNumberOperationOption {

    public FloorOption() {
        super("floor");
    }

    @Override
    public double calculate(double num) {
        return Math.floor(num);
    }

    @Override
    public @NotNull String format(double num, double answer) {
        return "floor(" + num + ") = " + answer;
    }
}
