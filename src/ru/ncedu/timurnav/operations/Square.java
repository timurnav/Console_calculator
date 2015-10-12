package ru.ncedu.timurnav.operations;

import ru.ncedu.timurnav.ConsoleHelper;

public class Square extends UnaryOperation {

    @Override
    public double execute(double n1) {
        ConsoleHelper.writeMessage(Math.sqrt(n1));
        return Math.sqrt(n1);
    }
}
