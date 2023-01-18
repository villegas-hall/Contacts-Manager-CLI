import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Contacts {

    private String name;
    private String phoneNumber;
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path contactFile = Paths.get(directory, filename);

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return this.name.toString() + " | " + this.phoneNumber.toString();
    }

    public static void addContact() throws IOException {
        String name = this.getName();
        String number = this.getPhoneNumber();

        Files.write(
                contactFile,
                Arrays.asList(name + number),
                StandardOpenOption.APPEND
        );
    }

    public static void showAll() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
    }


    public static void deleteContact(String name) throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

    }

    public static void findContact(String name) throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

    }
}