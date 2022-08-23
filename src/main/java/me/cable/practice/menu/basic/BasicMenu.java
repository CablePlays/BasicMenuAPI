package me.cable.practice.menu.basic;

import me.cable.practice.menu.Menu;
import me.cable.practice.menu.option.Option;
import me.cable.practice.menu.basic.option.RunnableOption;
import org.jetbrains.annotations.NotNull;

public class BasicMenu extends Menu {

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof RunnableOption runnableOption) {
            runnableOption.run();
        }
    }
}
