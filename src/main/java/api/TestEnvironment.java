package api;

import java.util.List;

public interface TestEnvironment {

    default void setInput(String... inputs) {
        Console.setMockInput(inputs);
    }

    default void setInput(List<String> inputs) {
        Console.setMockInput(inputs);
    }
}
