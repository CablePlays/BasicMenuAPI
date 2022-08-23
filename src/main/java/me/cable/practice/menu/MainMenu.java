package me.cable.practice.menu;

import me.cable.practice.Main;
import me.cable.practice.menu.basic.BasicMenu;
import me.cable.practice.menu.basic.sub.SubMenu;
import me.cable.practice.menu.calculator.CalculatorMenu;
import me.cable.practice.menu.basic.option.RunnableOption;

public class MainMenu extends BasicMenu {

    public MainMenu() {
        addOption(RunnableOption.create("calculator", () -> new CalculatorMenu().open()));
        addOption(RunnableOption.create("hello world", () -> Main.show("Hello World!")));
        addOption(RunnableOption.create("sub menu", () -> new SubMenu().open()));
    }
}
