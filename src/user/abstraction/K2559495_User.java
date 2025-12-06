package user.abstraction;

import java.util.ArrayList;
import java.util.List;
import user.strategy.K2559495_FineStrategy;

public abstract class K2559495_User {

    protected final String userId;
    protected String name;
    protected String email;
    protected String contactNumber;
    protected List<String> borrowedBooksHistory = new ArrayList<>();
    protected K2559495_FineStrategy fineStrategy;

    public K2559495_User(String userId, String name, String email, String contactNumber, K2559495_FineStrategy fineStrategy) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.fineStrategy = fineStrategy;
    }

    //Abstract method for borrowing limit and duration
    public abstract int getBorrowingLimit();

    public abstract int getBorrowDuration();

    public double calculateFine(int overdueDays) {
        return fineStrategy.calculateFine(overdueDays);
    }

    public void addBorrowedBook(String bookId) {
        borrowedBooksHistory.add(bookId);
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooksHistory;
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
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public abstract void displayUserInfo();

}
