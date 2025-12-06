package book.state;

import book.builder.K2559495_Book;
import book.builder.K2559495_BookBuilder;
import observer.*;
import user.abstraction.*;
import user.strategy.K2559495_StudentFine;

public class K2559495_BookStateDemo {

    public static void main(String[] args) {
        // Create a book
        K2559495_Book book = new K2559495_BookBuilder("B001", "Design Patterns", "Gamma", "12345")
                .addCategory("Software Engineering")
                .build();

        // Create two users
        K2559495_User borrower = new K2559495_Student("U001", "Saviska", "saviska@email.com", "0712345678", new K2559495_StudentFine());
        K2559495_User reserver = new K2559495_Student("U002", "Nimal", "nimal@email.com", "0771234567", new K2559495_StudentFine());

        // Create notification service and register user as observer
        K2559495_NotificationService service = new K2559495_NotificationService();

        // Create book context with initial state = Available
        K2559495_BookContext context = new K2559495_BookContext(new K2559495_AvailableState(), book);
        context.setNotificationService(service);

        System.out.println("Initial Book Status: " + context.getBookStatus());

// Borrower borrows the book
        context.borrow(borrower);
        System.out.println("Book Status after borrowing: " + context.getBookStatus());

// Reserver reserves the book
        context.reserve(reserver);
        System.out.println("Book Status after reserving: " + context.getBookStatus());

// Borrower returns the book
        context.returnBook(borrower);
        System.out.println("Book Status after returning: " + context.getBookStatus());

    }
}
