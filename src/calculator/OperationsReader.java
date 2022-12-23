package calculator;

import static java.util.Objects.isNull;

import calculator.operation.LazyOperand;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

public class OperationsReader {

    private static final Set<Character> NUMBERS = new HashSet<>();
    private static final String ADDITION_OPERATOR = "+";
    private static final String SUBTRACTION_OPERATOR = "-";

    static {
        NUMBERS.add('1');
        NUMBERS.add('2');
        NUMBERS.add('3');
        NUMBERS.add('4');
        NUMBERS.add('5');
        NUMBERS.add('6');
        NUMBERS.add('7');
        NUMBERS.add('8');
        NUMBERS.add('9');
        NUMBERS.add('0');
    }

    public static Operation readOperation(Reader reader) throws IOException {
        final var leftOperandBuffer = new StringBuilder();
        // тут будет + или - для определения типа операции
        String operator = null;
        while (true) {
            final var readInt = reader.read();
            if (readInt == -1) {
                break;
            }
            final var symbol = ((char) readInt);
            if (NUMBERS.contains(symbol)) {
                leftOperandBuffer.append(symbol);
                continue;
            }
            operator = String.valueOf(symbol);
            break;
        }

        // тут хранится левое число операции
        final double leftOperand = Double.parseDouble(leftOperandBuffer.toString());
        // тут остается правая часть операции (может быть пустым)
        final var rightOperator = new LazyOperand(reader);

        Operation operation = null;
        // выполняем сложение
        if (ADDITION_OPERATOR.equals(operator)) {
            // выбрать правильный тип операции, сохранить в operation
        }
        // выполняем вычитание
        else if (SUBTRACTION_OPERATOR.equals(operator)) {
            // выбрать правильный тип операции, сохранить в operation
        }
        // если не считали оператор, значит выражение закончилось
        else if (isNull(operator)) {
            // выбрать правильный тип операции, сохранить в operation
        }
        // передали строку, которую не можем считать, кидаем ошибку
        else {
            throw new IllegalArgumentException("Unknown operator " + operator);
        }
        return operation;
    }
}
