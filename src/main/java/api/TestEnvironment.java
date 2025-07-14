package api;

import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class TestEnvironment {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void run(String... inputs) {
        Console.setMockInput(inputs);
        runLogic();
    }

    public void run(List<String> inputs) {
        Console.setMockInput(inputs);
        runLogic();
    }

    private void runLogic() {
        System.setOut(new TeePrintStream(outContent, originalOut));
        try {
            runMain();
        } finally {
            System.setOut(originalOut);
        }
    }

    public String output() {
        return outContent.toString();
    }

    protected abstract void runMain();
}
