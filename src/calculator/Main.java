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
        Reader reader = null;
        try {
            switch (args[0]) {
                case "--expr":
                    reader = new StringReader(args[1]);
                    break;
                case "--file":
                    reader = new FileReader(args[1]);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "The only supported inputs are --expr {calculation expression} or "
                            + "--file {file path}");
            }
            Operation operation = OperationsReader.readOperation(reader);
            System.out.println(operation.calculate());
        } finally {
            reader.close();
        }
    }

}
