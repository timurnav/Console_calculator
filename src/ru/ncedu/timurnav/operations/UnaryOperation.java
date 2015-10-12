package ru.ncedu.timurnav.operations;

public abstract class UnaryOperation implements Operation {

    @Override
    @Deprecated
    public final double execute(double n1, double n2) {
        return execute(n1);
    }

    public abstract double execute(double n1);
}
