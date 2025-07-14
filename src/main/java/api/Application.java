package api;

public class Application {
    public static void main(String[] args) {
        System.out.println("이름을 입력하세요:");
        String name = Console.readLine();

        //throw new IllegalArgumentException();

        System.out.println("안녕하세요, " + name + "님!");
    }
}
