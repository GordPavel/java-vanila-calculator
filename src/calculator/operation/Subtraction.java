package calculator.operation;

import calculator.Operation;

/**
 * Должен выполнять вычитание
 */
public class Subtraction implements Operation {

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
