import java.util.Scanner;
//inside repo with src tests and bin execute commands:
// - javac -d bin src/*.java src/users/*.java src/activities/*.java 
// - java -cp bin Main

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Menu Menu = new Menu(scanner);

        Menu.displayMainMenu();

        scanner.close();
    }
}
