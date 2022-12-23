package calculator.operation;

import calculator.Operation;
import calculator.OperationsReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Нужен, чтобы не нужно было считывать все выражение сразу, а разбивать по разным операциям
 */
public class LazyOperand implements Operation {

    private final Reader readableOperand;

    public LazyOperand(Reader readableOperand) {
        this.readableOperand = readableOperand;
    }

    @Override
    public double calculate() {
        try {
            return OperationsReader.readOperation(readableOperand).calculate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
