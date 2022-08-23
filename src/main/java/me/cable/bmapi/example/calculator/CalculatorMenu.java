package me.cable.bmapi.example.calculator;

import me.cable.bmapi.Main;
import me.cable.bmapi.example.calculator.advanced.AdvancedCalculatorMenu;
import me.cable.bmapi.example.calculator.option.*;
import me.cable.bmapi.menu.Menu;
import me.cable.bmapi.option.Option;
import me.cable.bmapi.option.RunnableOption;
import org.jetbrains.annotations.NotNull;

public class CalculatorMenu extends Menu {

    public CalculatorMenu() {
        addOption(new AdditionOption());
        addOption(new SubtractionOption());
        addOption(new MultiplicationOption());
        addOption(new DivisionOption());
        addOption(new ModuloOption());
        addOption(new PowerOption());

        addOption(RunnableOption.create("advanced", () -> new AdvancedCalculatorMenu().open()));
    }

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof RunnableOption runnableOption) {
            runnableOption.run();
        } else if (option instanceof DoubleNumberOperationOption doubleNumberOperationOption) {
            double num1 = Double.parseDouble(Main.input("Input number 1"));
            double num2 = Double.parseDouble(Main.input("Input number 2"));
            double answer = doubleNumberOperationOption.calculate(num1, num2);

            String display = doubleNumberOperationOption.format(num1, num2, answer);
            Main.show(display);
        }
    }
}
