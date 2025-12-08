package user.admin;

public class K2559495_Librarian {

    private final String userId;
    private String name;
    private String email;
    private String contactNumber;
    private String password;

    public K2559495_Librarian(String userId, String name, String email, String contactNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayLibrarianInfo() {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::::::::::::: Librarian :::::::::::::::::::::::::::");
        System.out.println("Librarian ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Contact: " + contactNumber);
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

    }
}
