import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import api.Application;
import api.TestEnvironment;
import org.junit.jupiter.api.*;

public class ApplicationTest extends TestEnvironment {

    @Test
    void 이름테스트() {
        run("홍길동");
        assertTrue(output().contains("홍길동"));
    }

    @Test
    void 이름테스트2() {
        run("아무개");
        assertTrue(output().contains("아무개"));
    }


    @Test
    void 예외발생테스트() {
        assertThrows(IllegalArgumentException.class, () -> run("잘못된 입력"));
    }

    @Override
     public void runMain() {
        Application.main(new String[]{});
    }
}
