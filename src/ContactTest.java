import java.io.IOException;

public class ContactTest {
    public static void main(String[] args) throws IOException {
        ContactApp.readFromTxt();
        ContactApp.addContact("loser boy");
        ContactApp.showContacts();
    }
}
