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
    static Path dataDirectory = Paths.get(directory);
    static Path dataFile = Paths.get(directory, filename);

    /*reads array rather than .txt*/
    public static void showContacts(List<String> arr) {
        for (int i = 0; i < arr.size(); i += 1) {
            System.out.println((i + 1) + ": " + arr.get(i));
        }
    }
    /*reads .txt rather than the new array (if contact was added)*/
    public static List<String> readFromTxt() throws IOException {
        Path contactsPath = Paths.get("data", "contacts.txt");
        List<String> contactsList = Files.readAllLines(contactsPath);

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }

        return contactsList;
    }
    public static void addContact(List<String> arr) throws IOException {
        String name = input.getString("Enter contact name");
        String number = input.getString("Enter contact phone number");
        Contacts newContact = new Contacts(name, number);
        System.out.println("name = " + name);
        System.out.println("number = " + number);
        System.out.println("newContact = " + newContact);
//        Path filepath = Paths.get("data", "contacts.txt");
//        Files.write(filepath, arr);


//        arr.add(new Contacts(name, number));
    }


    public static void runCLI() {

    }
    public static void exitApp() throws IOException {
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(/*name + " | " + number*/), // list with one item
                StandardOpenOption.APPEND
        );
    }
    public static void main(String[] args) throws IOException {
//        Input input = new Input();

        /*exception handling*/
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        /*default contact creation*/
        Contacts contact1 = new Contacts("Joe Blow", "1234567");
        Contacts contact2 = new Contacts("Nombre Last", "1234567");
        Contacts contact3 = new Contacts("Zach Aria", "1234567");
        Contacts contact4 = new Contacts("Dirk Giggler", "1234567");
//        System.out.println("contacts.getName() = " + contacts.getName());
//        System.out.println("contacts.getPhone_number() = " + contacts.getPhone_number());

        List<String> contactList = Arrays.asList(contact1.getName() + " | " + contact1.getPhone_number(), contact2.getName() + " | " + contact2.getPhone_number(), contact3.getName() + " | " + contact3.getPhone_number(), contact4.getName() + " | " + contact4.getPhone_number());

        /*put in a new method*/
        Path filepath = Paths.get("data", "contacts.txt");
        Files.write(filepath, contactList);


//        showContacts(contactList);
        addContact(contactList);
    }
}
