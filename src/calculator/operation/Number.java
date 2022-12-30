package calculator.operation;

import calculator.Operation;

/**
 * Не выполняет операций, нужно для простого представления числа
 */
public class Number implements Operation {
    private final double number;

    public Number(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return this.number;
    }
}
