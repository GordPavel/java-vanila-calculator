package calculator.reader;

import calculator.Operation;
import calculator.OperationsReader;
import java.io.IOException;
import java.io.StringReader;

public class ArgsExpressionReader extends OperationsReader {

    public ArgsExpressionReader(String expression) {
        super(new StringReader(expression));
    }

    @Override
    public Operation readOperation() throws IOException {
        try {
            return readOperationInternal();
        } finally {
            reader.close();
        }
    }
}
