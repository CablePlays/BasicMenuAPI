package me.cable.bmapi.example;

import me.cable.bmapi.Main;
import me.cable.bmapi.example.calculator.CalculatorMenu;
import me.cable.bmapi.example.sub.SubMenu;
import me.cable.bmapi.menu.BasicMenu;
import me.cable.bmapi.option.RunnableOption;

public class MainMenu extends BasicMenu {

    public MainMenu() {
        addOption(RunnableOption.create("calculator", () -> new CalculatorMenu().open()));
        addOption(RunnableOption.create("hello world", () -> Main.show("Hello World!")));
        addOption(RunnableOption.create("sub menu", () -> new SubMenu().open()));
    }
}
