package me.cable.practice.menu.calculator.advanced;

import me.cable.practice.Main;
import me.cable.practice.menu.Menu;
import me.cable.practice.menu.calculator.advanced.option.*;
import me.cable.practice.menu.option.Option;
import org.jetbrains.annotations.NotNull;

public class AdvancedCalculatorMenu extends Menu {

    public AdvancedCalculatorMenu() {
        addOption(new SquareOption());
        addOption(new SquareRootOption());
        addOption(new FloorOption());
        addOption(new CeilOption());
    }

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof SingleNumberOperationOption singleNumberOperationOption) {
            double num = Double.parseDouble(Main.input("Input number"));
            double answer = singleNumberOperationOption.calculate(num);

            String display = singleNumberOperationOption.format(num, answer);
            Main.show(display);
        }
    }
}
