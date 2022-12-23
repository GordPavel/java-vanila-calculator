package calculator;

import calculator.operation.Addition;
import calculator.operation.Subtraction;

public class OperationOptimizer {

    public static Operation optimizeOperation(Operation operation) {
        if (operation instanceof Subtraction) {
            final var subtraction = (Subtraction) operation;
            final var subtractionLeft = optimizeOperation(subtraction.getLeft());
            final var subtractionRight = optimizeOperation(subtraction.getRight());
            if (!(subtractionRight instanceof Addition)) {
                return new Subtraction(subtractionLeft, subtractionRight);
            }
            final var rightAddition = (Addition) subtractionRight;
            final var additionLeft = optimizeOperation(rightAddition.getLeft());
            final var additionRight = optimizeOperation(rightAddition.getRight());
            return new Addition(new Subtraction(subtractionLeft, additionLeft), additionRight);
        } else if (operation instanceof Addition) {
            final var addition = (Addition) operation;
            final var additionLeft = optimizeOperation(addition.getLeft());
            final var additionRight = optimizeOperation(addition.getRight());
            return new Addition(additionLeft, additionRight);
        }
        return operation;
    }
}
