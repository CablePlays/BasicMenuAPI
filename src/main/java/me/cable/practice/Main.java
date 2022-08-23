package me.cable.practice;

import me.cable.practice.menu.MainMenu;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class Main {

    private static final String PREFIX = "[MENU] ";

    public static void main(String[] args) {
        new MainMenu().open();
        System.out.println("You have exited the menu.");
    }

    public static void show(@NotNull String text) {
        JOptionPane.showMessageDialog(null, PREFIX + text);
    }

    public static @NotNull String input(@NotNull String text) {
        String input = JOptionPane.showInputDialog(null, PREFIX + text);

        if (input == null) {
            throw new IllegalStateException("The menu has been closed");
        }

        return input;
    }
}
