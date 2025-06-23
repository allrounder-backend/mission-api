import static org.junit.jupiter.api.Assertions.assertEquals;

import api.Application;
import api.Console;
import api.TestEnvironment;
import java.util.List;
import org.junit.jupiter.api.*;

public class ApplicationTest implements TestEnvironment {

    @Test
    void 이름테스트() {
        setInput("홍길동");
        String name = Console.readLine();
        assertEquals("홍길동", name);
    }

    @Test
    void 이름테스트2() {
        setInput("홍길동", "아무개");
        String name = Console.readLine();
        assertEquals("홍길동", name);
        assertEquals("아무개", Console.readLine());
    }

    @Test
    void 이름테스트3() {
        setInput(List.of("홍길동", "아무개"));
        String name = Console.readLine();
        assertEquals("홍길동", name);
        assertEquals("아무개", Console.readLine());
    }
}
