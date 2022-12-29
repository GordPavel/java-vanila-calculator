package calculator.operation;

import calculator.Operation;

/**
 * Должен выполнять вычитание
 */
public class Subtraction implements Operation {
    private final Operation left;
    private final Operation right;

    public Subtraction(Operation left, Operation right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double calculate() {
        return left.calculate() - right.calculate();
    }

    public Operation getLeft() {
        return this.left;
    }

    public Operation getRight() {
        return this.right;
    }
}
