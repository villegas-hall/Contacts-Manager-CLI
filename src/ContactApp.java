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


    /*reads array rather than .txt*/
    public static void showContacts(List<String> arr) {
        for (int i = 0; i < arr.size(); i += 1) {
            System.out.println((i + 1) + ": " + arr.get(i));
        }
        System.out.print("\n");
    }

    /*reads .txt rather than the new array (if contact was added)*/
    public static List<String> readFromTxt() throws IOException {
        Path contactsPath = Paths.get("data", "contacts.txt");

        return Files.readAllLines(contactsPath);
    }

    public static void addContact(List<Contacts> workingArray) {
        /*creates new contact*/
        String name = input.getString("Enter contact name");
        String number = input.getString("Enter contact phone number");
        Contacts newContact = new Contacts(name, number);

        System.out.println("name = " + name);
        System.out.println("number = " + number);
        System.out.println("newContact = " + newContact);

        /*adds new contact to contact-object list*/
        workingArray.add(newContact);
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

            List<String> workingArray = readFromTxt();
            List<Contacts> contactArr = new ArrayList<>();

            switch (userInput) {
                case 1 -> {
                    Contacts.showAll();
                    runCLI();
                }
                case 2 -> {
                    Contacts.addContact();
                    runCLI();
                }
//                case 3 -> searchForContact();
//                case 4 -> deleteContact();
                case 5 -> {
                    exitApp();
                    restart = false;
                }
                default -> System.out.println("That isn't a valid option. Please choose again.");
            }
        }
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
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//
//        if (!Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }

        /*default contact creation*/
        Contacts contact1 = new Contacts("Joe Blow", "1234567");
        Contacts contact2 = new Contacts("Nombre Last", "1234567");
        Contacts contact3 = new Contacts("Zach Aria", "1234567");
        Contacts contact4 = new Contacts("Dirk Giggler", "1234567");
//        System.out.println("contacts.getName() = " + contacts.getName());
//        System.out.println("contacts.getPhoneNumber() = " + contacts.getPhoneNumber());

        List<String> contactList = Arrays.asList(contact1.getName() + " | " + contact1.getPhoneNumber(), contact2.getName() + " | " + contact2.getPhoneNumber(), contact3.getName() + " | " + contact3.getPhoneNumber(), contact4.getName() + " | " + contact4.getPhoneNumber());

        /*put in a new method*/
        Path filepath = Paths.get("data", "contacts.txt");
        Files.write(filepath, contactList);


//        showContacts(contactList);
//        addContact(contactList);
    }
}
