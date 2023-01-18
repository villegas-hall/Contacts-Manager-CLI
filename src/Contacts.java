import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {

    private String name;
    private String phoneNumber;
    static String directory = "data";
    static String filename = "contacts.txt";
    static Path contactFile = Paths.get(directory, filename);

    static Input input = new Input();

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

    /// This works
    public static void addContact() throws IOException {
        String name = input.getString("Enter contact name");
        String number = input.getString("Enter contact phone number");

        Files.write(
                contactFile,
                Arrays.asList(name + " | " + number),
                StandardOpenOption.APPEND
        );

        Contacts newContact = new Contacts(name, number);
        System.out.println("newContact = " + newContact);
    }

//    public static void addContact() throws IOException {
//        String name = input.getString("Enter contact name");
//        String number = input.getString("Enter contact phone number");
//
//        List<String> contactList = Files.readAllLines(contactFile);
//        List<String> newList = new ArrayList<>();
//
//        for (String person : contactList) {
//            if (person.toLowerCase().contains(name.toLowerCase()) || person.toLowerCase().contains(number.toLowerCase())) {
//                System.out.println(person + ", already exists. Would you like to overwrite? (y/n)");
//                if (input.yesNo()) {
//                    newList.add("cream");
//                    continue;
//                } else {
//                    System.out.println("No changes made to contact list");
//                }
//            }
//            newList.add(person);
//        }
//
//        Files.write(
//                contactFile,
//                Arrays.asList(name + " | " + number),
//                StandardOpenOption.APPEND
//        );
//    }

    public static void showAll() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        for (int i = 0; i < contactList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactList.get(i));
        }
        System.out.println("");
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
        System.out.println("");
    }

    public static void findContact() throws IOException {
        List<String> contactList = Files.readAllLines(contactFile);

        String searchInput = input.getString("Enter the name or number to be searched");
        for (String person : contactList) {
            if (person.toLowerCase().contains(searchInput.toLowerCase())) {
                System.out.println("Contact: " + person);
//            } else {
//                System.out.println("No such person exist in my world.");
//            }
            }
        }
    }

}