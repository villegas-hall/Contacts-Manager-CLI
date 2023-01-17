public class Contacts {

    private String name;
    private int phone_number;

    public Contacts(String name, int phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

//    public static void viewContacts() {
//        for (int i = 0; i < contactList.size(); i += 1) {
//
//            System.out.println((i + 1) + ": " + contactList.get(i));
//        }
//    }

    
}
