package calculator.reader;

import calculator.Operation;
import calculator.OperationsReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExpressionReader extends OperationsReader {

    public FileExpressionReader(String filePath) throws FileNotFoundException {
        super(new FileReader(filePath));
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
