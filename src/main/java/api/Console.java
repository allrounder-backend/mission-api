package api;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class Console {
    private static final ThreadLocal<Queue<String>> mockInput = new ThreadLocal<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        if (isTestEnvironment()) {
            return getMockInput();
        }
        return scanner.nextLine();
    }

    static void setMockInput(String... inputs) {
        mockInput.set(new LinkedList<>(List.of(inputs)));
    }

    static void setMockInput(List<String> inputs) {
        mockInput.set(new LinkedList<>(inputs));
    }

    private static String getMockInput() {
        Queue<String> queue = mockInput.get();
        if (queue == null || queue.isEmpty()) {
            throw new NoSuchElementException("[Console] Mock input is not set.");
        }
        return queue.poll();
    }

    private static boolean isTestEnvironment() {
        return Arrays.stream(Thread.currentThread().getStackTrace())
                .map(StackTraceElement::getClassName)
                .distinct()
                .anyMatch(Console::extendTestEnvironment);
    }

    private static boolean extendTestEnvironment(String className) {
        try {
            return TestEnvironment.class.isAssignableFrom(Class.forName(className));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
