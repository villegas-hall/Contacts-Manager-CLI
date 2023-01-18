import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactApp {
    static Input input = new Input();
    static String directory = "data";
    static String filename = "contacts.txt";

    public static void main(String[] args) throws IOException {
        runCLI();
        /*exception handling*/
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//
//        if (!Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }
    }
    public static void runCLI() throws IOException {
        boolean restart = true;

        while (restart) {
            System.out.println(
                    "1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n");
            int userInput = input.getInt(1, 5);

            switch (userInput) {
                case 1 -> Contacts.showAll();

                case 2 -> Contacts.addContact();

                case 3 -> Contacts.findContact();

                case 4 -> Contacts.deleteContact();

                case 5 -> restart = false;

                default -> System.out.println("That isn't a valid option. Please choose again.");
            }
        }
        System.out.println("Goodbye.");
    }
}
