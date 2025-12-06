package user.abstraction;

import user.strategy.K2559495_StudentFine;

public class K2559495_Student extends K2559495_User {

    public K2559495_Student(String userId, String name, String email, String contactNumber, K2559495_StudentFine fineStrategy) {
        super(userId, name, email, contactNumber, fineStrategy);
    }

    @Override
    public int getBorrowingLimit() {
        return 5; // Students can borrow up to 5 books
    }

    @Override
    public void displayUserInfo() {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::::::::::: Student Member ::::::::::::::::::::::::");
        System.out.println("User ID: " + super.userId);
        System.out.println("Name: " + super.name);
        System.out.println("Email: " + super.email);
        System.out.println("Contact Number: " + super.contactNumber);
        System.out.println("Fine Rate: " + super.calculateFine(1) + " LKR per day");
        System.out.println("Borrowed Books History: ");
        for (String bookId : super.borrowedBooksHistory) {
            System.out.println("\t\t\t #" + bookId);
        }
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }
}
