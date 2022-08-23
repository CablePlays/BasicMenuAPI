package me.cable.bmapi.menu;

import me.cable.bmapi.option.Option;
import me.cable.bmapi.option.RunnableOption;
import org.jetbrains.annotations.NotNull;

public class BasicMenu extends Menu {

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof RunnableOption runnableOption) {
            runnableOption.run();
        }
    }
}
