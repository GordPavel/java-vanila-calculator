package calculator.operation;

import calculator.Operation;

/**
 * Должен выполнять сложение
 */
public class Addition implements Operation {

    @Override
    public double calculate() {

    }

    public Operation getLeft() {
        return left;
    }

    public Operation getRight() {
        return right;
    }
}
