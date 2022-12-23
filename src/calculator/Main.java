package calculator;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Main {

    /**
     * Программу можно вызвать с аргументами --expr {тут вычисляемое выражение без пробелов, например 10-3+4}
     * или --file {путь до файла с выражением}.
     * Поддерживаются только сложения или вычитания. Можете реализовать другие операции) но сложнее будет с порядком
     * операций.
     */
    public static void main(String[] args) throws IOException {
        Operation operation;
        switch (args[0]) {
            case "--expr":
                operation = readFromArgs(args[1]);
                break;
            case "--file":
                operation = readFromFile(args[1]);
                break;
            default:
                throw new IllegalArgumentException("The only supported inputs are --expr {calculation expression} or "
                                                       + "--file {file path}");
        }
        System.out.println(operation.calculate());
    }

    private static Operation readFromArgs(String expression) throws IOException {
        try (Reader reader = new StringReader(expression)) {
            return OperationsReader.readOperation(reader);
        }
    }

    private static Operation readFromFile(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return OperationsReader.readOperation(reader);
        }
    }
}
