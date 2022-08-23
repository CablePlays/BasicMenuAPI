package me.cable.practice.menu.basic.sub;

import me.cable.practice.Main;
import me.cable.practice.menu.basic.BasicMenu;
import me.cable.practice.menu.basic.option.RunnableOption;

public class SubMenu extends BasicMenu {

    public SubMenu() {
        addOption(RunnableOption.create("hello", () -> Main.show("Hey!")));
    }
}
