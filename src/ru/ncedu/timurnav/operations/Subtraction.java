package ru.ncedu.timurnav.operations;

import ru.ncedu.timurnav.ConsoleHelper;

public class Subtraction implements Operation{
    @Override
    public double execute(double n1, double n2) {
        ConsoleHelper.writeMessage(n1 - n2);
        return n1 - n2;
    }
}
