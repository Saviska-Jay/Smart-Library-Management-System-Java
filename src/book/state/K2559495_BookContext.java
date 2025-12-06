package book.state;

import observer.K2559495_NotificationService;
import observer.K2559495_UserObserver;
import book.builder.K2559495_Book;
import user.abstraction.K2559495_User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class K2559495_BookContext {

    private K2559495_BookState currentState;
    private K2559495_NotificationService notificationService;
    private K2559495_Book book;

    private LocalDate dueDate;
    private List<String> borrowedHistory = new ArrayList<>();

    public K2559495_BookContext(K2559495_BookState state, K2559495_Book book) {
        this.currentState = state;
        this.book = book;
    }

    public List<String> getBorrowedHistory() {
        return borrowedHistory;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public K2559495_Book getBook() {
        return book;
    }

    public void setState(K2559495_BookState state) {
        this.currentState = state;
    }

    // Borrow logic with borrowing limit check
    public void borrow(K2559495_User user) {
        if (currentState instanceof K2559495_AvailableState
                && user.getBorrowedBooks().size() < user.getBorrowingLimit()) {

            currentState.borrow(this);
            borrowedHistory.add(user.getUserId());

            // Assign due date based on membership type
            dueDate = LocalDate.now().plusDays(user.getBorrowDuration());
            user.addBorrowedBook(book.getBookId());

            System.out.println(user.getName() + " borrowed: " + book.getTitle()
                    + " (Due: " + dueDate + ")");
        } else {
            System.out.println("Borrow not allowed for " + user.getName());
        }
    }

    // Return logic with fine calculation
    public void returnBook(K2559495_User user) {
        currentState.returnBook(this);

        if (dueDate != null) {
            long overdueDays = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            if (overdueDays > 0) {
                double fine = user.calculateFine((int) overdueDays); // <-- use User API
                System.out.println("Fine for " + user.getName() + ": LKR " + fine);
            }
        }

        user.getBorrowedBooks().remove(book.getBookId());
        dueDate = null;
    }

    // Reserve logic with observer registration
    public void reserve(K2559495_User user) {
        if (currentState instanceof K2559495_BorrowedState) {
            currentState.reserve(this);

            if (notificationService != null) {
                notificationService.addObserver(new K2559495_UserObserver(user));
            }

            System.out.println(user.getName() + " reserved: " + book.getTitle());
        } else {
            System.out.println("Reservation not allowed for " + book.getTitle());
        }
    }

    public String getBookStatus() {
        return currentState.getBookStatus();
    }


    //For testing purposes
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setNotificationService(K2559495_NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public K2559495_NotificationService getNotificationService() {
        return notificationService;
    }
}
