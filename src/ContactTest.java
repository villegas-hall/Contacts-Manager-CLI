import java.io.IOException;
import java.util.List;

public class ContactTest {
    public static void main(String[] args) throws IOException {

        List<String> workingArray = ContactApp.readFromTxt();
        ContactApp.readFromTxt();
        ContactApp.addContact("loser boy", "1234567", workingArray);
        ContactApp.showContacts(workingArray);
    }
}
