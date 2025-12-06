package user.abstraction;
import user.strategy.K2559495_StudentFine;
import user.strategy.K2559495_FacultyFine;
import user.strategy.K2559495_GuestFine;

public class K2559495_UserDemo {
    public static void main(String[] args) {
        K2559495_Student student = new K2559495_Student("S001", "Alice","Alice@email.com", "0771234567", new K2559495_StudentFine());
        student.addBorrowedBook("B001");
        student.displayUserInfo();
        double fine = student.calculateFine(3); // 3 days overdue
        System.out.println("Fine for 3 overdue days: " + fine + " LKR \n \n");

        K2559495_Faculty faculty = new K2559495_Faculty("F001", "Dr. Bob","bob@email.com", "0777654321", new K2559495_FacultyFine());
        faculty.addBorrowedBook("B002");
        faculty.displayUserInfo();
        fine = faculty.calculateFine(5); // 5 days overdue
        System.out.println("Fine for 5 overdue days: " + fine + " LKR \n \n");

        K2559495_Guest guest = new K2559495_Guest("G001", "Charlie","charlie@email.com", "0779876543", new K2559495_GuestFine());
        guest.addBorrowedBook("B003");
        guest.displayUserInfo();
        fine = guest.calculateFine(2); // 2 days overdue
        System.out.println("Fine for 2 overdue days: " + fine + " LKR \n \n");

    }
}