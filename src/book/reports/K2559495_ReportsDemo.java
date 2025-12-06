package book.reports;

import book.builder.K2559495_Book;
import book.builder.K2559495_BookBuilder;
import book.state.*;
import java.time.LocalDate;
import user.abstraction.*;
import user.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class K2559495_ReportsDemo {

    public static void main(String[] args) {
        // Create sample books
        K2559495_Book book1 = new K2559495_BookBuilder("B001", "Design Patterns", "Gamma", "12345")
                .addCategory("Software Engineering").build();
        K2559495_Book book2 = new K2559495_BookBuilder("B002", "Clean Code", "Martin", "67890")
                .addCategory("Programming").build();
        K2559495_Book book3 = new K2559495_BookBuilder("B003", "Algorithms", "Cormen", "54321")
                .addCategory("Computer Science").build();

        // Create users
        K2559495_User student = new K2559495_Student("U001", "Saviska", "saviska@email.com", "0712345678", new K2559495_StudentFine());
        K2559495_User faculty = new K2559495_Faculty("U002", "Dr. Perera", "perera@uni.com", "0771234567", new K2559495_FacultyFine());
        K2559495_User guest = new K2559495_Guest("U003", "Nimal", "nimal@gmail.com", "0759876543", new K2559495_GuestFine());

        // Create contexts
        K2559495_BookContext context1 = new K2559495_BookContext(new K2559495_AvailableState(), book1);
        K2559495_BookContext context2 = new K2559495_BookContext(new K2559495_AvailableState(), book2);
        K2559495_BookContext context3 = new K2559495_BookContext(new K2559495_AvailableState(), book3);

        // Simulate borrowing
        context1.borrow(student);   // student borrows book1
        context1.returnBook(student); // student returns book1

        context2.borrow(faculty);   // faculty borrows book2
        // Force overdue for testing
        context2.setDueDate(LocalDate.of(2025, 11, 20));

        context3.borrow(guest);     // guest borrows book3
        context3.returnBook(guest); // guest returns book3

        // Collect contexts and users
        List<K2559495_BookContext> bookContexts = new ArrayList<>();
        bookContexts.add(context1);
        bookContexts.add(context2);
        bookContexts.add(context3);

        List<K2559495_User> users = new ArrayList<>();
        users.add(student);
        users.add(faculty);
        users.add(guest);

        // Run reports
        K2559495_MostBorrowedBooksReport.generate(bookContexts, 3);
        K2559495_ActiveBorrowersReport.generate(users, 3);
        K2559495_OverdueBooksReport.generate(bookContexts);
    }
}
