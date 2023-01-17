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

    public static void showContacts(List<String> arr){
        for (int i = 0; i < arr.size(); i += 1) {
            System.out.println((i + 1) + ": " + arr.get(i));
        }
    }

    public static void addContact (List<String> arr){
        String name = input.getString("Enter contact name");
        String number = input.getString("Enter contact phone number");
        Contacts newContact = new Contacts(name, number);
        System.out.println("name = " + name);
        System.out.println("number = " + number);
        System.out.println("newContact = " + newContact);
        arr.add(newContact);
//        Path filepath = Paths.get("data", "contacts.txt");
//        Files.write(filepath, arr);
    }


    public static void main(String[] args) throws IOException {
//        Input input = new Input();
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        Contacts contact1 = new Contacts("Joe Blow", "1234567");
        Contacts contact2 = new Contacts("Nombre Last", "1234567");
        Contacts contact3 = new Contacts("Zach Aria", "1234567");
        Contacts contact4 = new Contacts("Dirk Giggler", "1234567");
//        System.out.println("contacts.getName() = " + contacts.getName());
//        System.out.println("contacts.getPhone_number() = " + contacts.getPhone_number());


        List<String> contactList = Arrays.asList(contact1.getName() + " | " + contact1.getPhone_number(),contact2.getName() + " | " + contact2.getPhone_number(), contact3.getName() + " | " + contact3.getPhone_number(), contact4.getName() + " | " + contact4.getPhone_number());


        Path filepath = Paths.get("data", "contacts.txt");
        Files.write(filepath, contactList);


        showContacts(contactList);
        addContact(contactList);





    }
}
