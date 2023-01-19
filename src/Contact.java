import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contact {

    private String name;
    private String phoneNumber;
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path contactFile = Paths.get(directory, filename);

    static Input input = new Input();

    public Contact(String name, String phoneNumber) {
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

    /// This works
    public static void showAll() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        System.out.println("Name | Phone number\n" +
                "---------------");

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
        System.out.println(' ');
    }

    public static void addContact() throws IOException {
        String name = input.getString("Enter contact name");
        String number = input.getString("Enter contact phone number");

        ////https://howtodoinjava.com/java/string/format-phone-number/
        String formattedNumber = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");

        Files.write(
                contactFile,
                Arrays.asList(name + " | " + formattedNumber),
                StandardOpenOption.APPEND
        );

        Contact newContact = new Contact(name, formattedNumber);
        System.out.println("newContact = " + newContact);
    }

    public static void findContact() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        String searchInput = input.getString("Enter the name or number to be searched");
        for (String person : contactList) {
            if (person.toLowerCase().contains(searchInput.toLowerCase())) {
                System.out.println("Contact: " + person);
            }
        }
    }

    public static void deleteContact() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        String contactToDelete = input.getString("Enter contact to delete (name/phone number)");
        List<String> emptyList = new ArrayList<>();
        for (String contact : contactList) {
            if (contact.toLowerCase().contains(contactToDelete)) {
                continue;
            }
            emptyList.add(contact);
        }
        Files.write(Paths.get("data", "contacts.txt"), emptyList);
    }

}