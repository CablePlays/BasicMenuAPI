package me.cable.bmapi.menu;

import me.cable.bmapi.Main;
import me.cable.bmapi.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    private static final String BACK = "back";

    private final List<Option> options = new ArrayList<>();

    public void addOption(@NotNull Option option) {
        options.add(option);
    }

    public void addOption(@NotNull String name) {
        addOption(new Option(name));
    }

    private @Nullable Option getOption(@NotNull String input) {
        List<Option> potential = new ArrayList<>();

        for (Option option : options) {
            String name = option.getName();

            if (name.equals(input)) {
                return option;
            } else if (name.startsWith(input)) {
                potential.add(option);
            }
        }

        int size = potential.size();

        if (size == 0) {
            Main.show("That is an invalid option!");
        } else if (size > 1) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    builder.append((i == size - 1) ? " and " : ", ");
                }

                builder.append('\'').append(potential.get(i).getName()).append('\'');
            }

            Main.show("Could not chose between " + builder);
        } else {
            return potential.get(0);
        }

        return null;
    }

    public abstract void runOption(@NotNull Option option);

    public void open() {
        StringBuilder b = new StringBuilder("What would you like to do? (");
        boolean first = true;

        for (Option option : options) {
            if (first) {
                first = false;
            } else {
                b.append(", ");
            }

            b.append('\'').append(option.getName()).append('\'');
        }

        b.append(") ('").append(BACK).append("')");

        while (true) {
            String input = Main.input(b.toString());

            if (input.equals(BACK)) {
                break;
            }

            Option option = getOption(input);

            if (option != null) {
                runOption(option);
            }
        }
    }
}
