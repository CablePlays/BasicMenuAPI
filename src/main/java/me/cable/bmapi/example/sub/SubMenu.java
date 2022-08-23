package me.cable.bmapi.example.sub;

import me.cable.bmapi.Main;
import me.cable.bmapi.menu.Menu;
import me.cable.bmapi.option.Option;
import org.jetbrains.annotations.NotNull;

public class SubMenu extends Menu {

    public SubMenu() {
        addOption("hi");
        addOption("bye");
    }

    @Override
    public void runOption(@NotNull Option option) {
        switch (option.getName()) {
            case "hi" -> {
                Main.show("Hey!");
            }
            case "bye" -> {
                Main.show("Goodbye!");
            }
        }
    }
}
