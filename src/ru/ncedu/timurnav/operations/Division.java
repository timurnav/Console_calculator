package ru.ncedu.timurnav.operations;

import ru.ncedu.timurnav.ConsoleHelper;

public class Division implements Operation{
    @Override
    public double execute(double n1, double n2) {
        if (n2!=0) {
            ConsoleHelper.writeMessage(n1/n2);
            return n1 / n2;
        }
        ConsoleHelper.writeMessage("Division by zero is not supported");
        return 0;
    }
}
