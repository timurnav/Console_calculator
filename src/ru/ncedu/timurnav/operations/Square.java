package ru.ncedu.timurnav.operations;

import ru.ncedu.timurnav.ConsoleHelper;

public class Square implements UnaryOperation {
    @Override
    public double execute(double n1, double n2) {
        ConsoleHelper.writeMessage(Math.sqrt(n1));
        return Math.sqrt(n1);
    }
}
