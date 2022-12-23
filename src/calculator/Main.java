package calculator;

import calculator.reader.ArgsExpressionReader;
import calculator.reader.FileExpressionReader;
import java.io.IOException;

public class Main {

    /**
     * Программу можно вызвать с аргументами --expr {тут вычисляемое выражение без пробелов, например 10-3+4}
     * или --file {путь до файла с выражением}.
     * Поддерживаются только сложения или вычитания. Можете реализовать другие операции) но сложнее будет с порядком
     * операций.
     */
    public static void main(String[] args) throws IOException {
        OperationsReader reader;
        switch (args[0]) {
            case "--expr":
                reader = new ArgsExpressionReader(args[1]);
                break;
            case "--file":
                reader = new FileExpressionReader(args[1]);
                break;
            default:
                throw new IllegalArgumentException(
                    "The only supported inputs are --expr {calculation expression} or "
                        + "--file {file path}");
        }
        Operation operation = OperationOptimizer.optimizeOperation(reader.readOperation());
        System.out.println(operation.calculate());
    }

}
