# BasicMenuAPI

An API that allows you to easily create stackable menus that use JOptionPane.

## Options

An option is a single piece of functionality that menus provide.
At the core, all an option requires is a name, which will displayed in the menu for the user to select.
From there, you can create your own types of options.
This API comes with a ready-to-use `Option` called `RunnableOption`, which is an `Option` that implements the `Runnable`
class and is run with no input (parameters).

## Menus

A menu represents a single JOptionPane input dialog and contains multiple `Option`s that the user will be able to
interact with.
Create your first menu using the `BasicMenu` class, and then add options to it inside its constructor using
the `addOption(Option)` method.

```java
public class MyMenu extends BasicMenu {

    public MyMenu() {
        addOption(new RunnableOption("say hi") {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
    }
}
```

This is a lot for a single option. Reduce your amount of code by making use of the static `create(String, Runnable)`
method inside the `RunnableOption` class.

```java
public class MyMenu extends BasicMenu {

    public MyMenu() {
        addOption(RunnableOption.create("say hi", () -> JOptionPane.showMessageDialog(null, "Hello World!")));
    }
}
```

To open your menu, call the `open()` method, and a dialog will pop up asking the user what they want to do.
When they type `say hi`, a dialog will open with the text `Hello World!`.

```java
public static void main(String[]args) {
    new MyMenu().open();
}
```

## Advanced Menus

Some options you create may require user input.
While this can be from within the `run()` method of a `RunnableOption`, it could be redundant if you have a few options
that require the same type of input.
Take a calculator menu as an example; we have 5 options - addition, subtraction, multiplication, division, modulo - and
each of them require 2 numbers from the user.
We could retrieve these 2 numbers from within every option individually, or we could get these numbers first and then
provide them to the option.
To do this, we need to create our own option type.

```java
public abstract class OperationOption extends Option {

    public DoubleNumberOperationOption(@NotNull String name) {
        super(name);
    }

    public abstract double calculate(double num1, double num2);

    public abstract @NotNull String format(double num1, double num2, double answer);
}
```

The above operation has 2 methods; one to calculate the answer using the 2 numbers, and another to format the equation.
We now make use of this class by creating a class for every operation we want our menu to have.
Here is what the addition operation class would look like:

```java
public class AdditionOption extends OperationOption {

    public AdditionOption() {
        super("add"); // the name of the option
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public @NotNull String format(double num1, double num2, double answer) {
        return num1 + " + " + num2 + " = " + answer; // e.g. 1 + 2 = 3
    }
}
```

Next, we need to tell our menu how to use this option type, because a `BasicMenu` only knows how to handle `RunnableOption`s.
To do this, we create our own `Menu` type and override the `runOption(Option)` method.

```java
public class CalculatorMenu extends Menu {

    public CalculatorMenu() {
        addOption(new AdditionOption()); // don't forget to add your operation options
    }

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof DoubleNumberOperationOption operationOption) {
            double num1 = Double.parseDouble(Main.input("Provide the first number"));
            double num2 = Double.parseDouble(Main.input("Provide the second number"));
            double answer = operationOption.calculate(num1, num2);

            String display = operationOption.format(num1, num2, answer);
            JOptionPane.showMessageDialog(null, display);
        }
    }
}
```

Now, whenever the user selects a `OperationOption`, the user will be asked for 2 numbers for the operation.
Keep in mind that if an `Operation` of a different type is added to the menu and selected by the user, it will not be
handled by this current method.
In the same way, the `BasicMenu` only knows how to handle options of the `RunnableOption` type.
In case you are curious, here is what the `runOperation(Operation)` method looks like inside the `BasicMenu` class:

```java
public class BasicMenu extends Menu {

    @Override
    public void runOption(@NotNull Option option) {
        if (option instanceof RunnableOption runnableOption) {
            runnableOption.run();
        }
    }
}
```

## Avoiding Options

It is possible for you to set up a menu system without using options.
Create your menu, but use the `addOption(String)` method instead of the one that takes in an `Option`.
This will automatically create and add a `Option` to your menu for you.

```java
public class MyMenu extends Menu {

    public MyMenu() {
        addOption("say hi");
    }
}
```

Create a switch statement inside the `runOption(Option)` method that checks the option's name.
Perform your tasks depending on the name of the option.

```java
public class MyMenu extends Menu {

    public MyMenu() {
        addOption("say hi");
    }

    @Override
    public void runOption(@NotNull Option option) {
        switch (option.getName()) {
            case "say hi" -> {
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        }
    }
}
```