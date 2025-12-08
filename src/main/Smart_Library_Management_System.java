package main;

import user.admin.K2559495_Librarian;
import book.builder.*;
import book.state.*;
import command.*;
import observer.*;
import user.abstraction.*;
import user.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Smart_Library_Management_System {

    private List<K2559495_BookContext> bookContexts = new ArrayList<>();
    private List<K2559495_User> users = new ArrayList<>();
    private List<K2559495_Librarian> librarians = new ArrayList<>();
    private K2559495_NotificationService notificationService = new K2559495_NotificationService();

    // ==================== BOOK MANAGEMENT ====================
    public K2559495_Book addBook(String title, String author, String category, String isbn) {
        try {
            String bookId = "B" + String.format("%03d", bookContexts.size() + 1);

            K2559495_Book book = new K2559495_BookBuilder(bookId, title, author, isbn)
                    .addCategory(category).build();

            K2559495_BookContext context = new K2559495_BookContext(new K2559495_AvailableState(), book);
            context.setNotificationService(notificationService);
            bookContexts.add(context);

            System.out.println("[Book Added] " + book.getTitle() + " (ID: " + book.getBookId() + ")");
            return book;
        } catch (Exception e) {
            System.out.println("[Error] Failed to add book: " + e.getMessage());
            return null;
        }
    }

    public K2559495_Book updateBook(String bookId, String newTitle, String newAuthor, String newCategory, String newIsbn) {
        try {
            for (K2559495_BookContext context : bookContexts) {
                if (context.getBook().getBookId().equals(bookId)) {
                    K2559495_Book book = context.getBook();
                    if (newTitle != null) {
                        book.updateTitle(newTitle);
                    }
                    if (newAuthor != null) {
                        book.updateAuthor(newAuthor);
                    }
                    if (newCategory != null) {
                        book.updateCategory(newCategory);
                    }
                    if (newIsbn != null) {
                        book.updateIsbn(newIsbn);
                    }

                    System.out.println("[Book Updated] " + book.getTitle() + " (ID: " + book.getBookId() + ")");
                    return book;
                }
            }
            System.out.println("[Error] Book ID not found: " + bookId);
            return null;
        } catch (Exception e) {
            System.out.println("[Error] Failed to update book: " + e.getMessage());
            return null;
        }
    }

    public boolean removeBook(String bookId) {
        try {
            for (K2559495_BookContext context : bookContexts) {
                if (context.getBook().getBookId().equals(bookId)) {
                    bookContexts.remove(context);
                    System.out.println("[Book Removed] ID: " + bookId);
                    return true;
                }
            }
            System.out.println("[Error] Book ID not found: " + bookId);
            return false;
        } catch (Exception e) {
            System.out.println("[Error] Failed to remove book: " + e.getMessage());
            return false;
        }
    }

    // ==================== BORROW / RESERVE / RETURN ====================
    public void borrowBook(String userId, String bookId) {
        try {
            K2559495_User user = findUserById(userId);
            K2559495_BookContext context = findBookContextById(bookId);

            if (user == null || context == null) {
                System.out.println("[Error] Invalid User ID or Book ID.");
                return;
            }

            K2559495_Command borrowCommand = new K2559495_BorrowCommand(user, context);
            borrowCommand.execute();
        } catch (Exception e) {
            System.out.println("[Error] Borrow operation failed: " + e.getMessage());
        }
    }

    public void reserveBook(String userId, String bookId) {
        try {
            K2559495_User user = findUserById(userId);
            K2559495_BookContext context = findBookContextById(bookId);

            if (user == null || context == null) {
                System.out.println("[Error] Invalid User ID or Book ID.");
                return;
            }

            K2559495_Command reserveCommand = new K2559495_ReserveCommand(user, context);
            reserveCommand.execute();
        } catch (Exception e) {
            System.out.println("[Error] Reserve operation failed: " + e.getMessage());
        }
    }

    public void returnBook(String userId, String bookId) {
        try {
            K2559495_User user = findUserById(userId);
            K2559495_BookContext context = findBookContextById(bookId);

            if (user == null || context == null) {
                System.out.println("[Error] Invalid User ID or Book ID.");
                return;
            }

            K2559495_Command returnCommand = new K2559495_ReturnCommand(user, context);
            returnCommand.execute();
        } catch (Exception e) {
            System.out.println("[Error] Return operation failed: " + e.getMessage());
        }
    }

    // ==================== USER MANAGEMENT ====================
    public void addLibrarian(String name, String email, String contactNumber, String password) {
        String librarianId = "L" + String.format("%03d", librarians.size() + 1);
        K2559495_Librarian librarian = new K2559495_Librarian(librarianId, name, email, contactNumber, password);
        librarians.add(librarian);
        System.out.println("[Librarian Added] Name : " + name );
    }

    public boolean loginLibrarian(String email, String password) {
        for (K2559495_Librarian librarian : librarians) {
            if (librarian.getEmail().equalsIgnoreCase(email) && librarian.getPassword().equals(password)) {
                System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println("[Login Successful] Welcome, " + librarian.getName());
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
                return true; 
            }
        }
        System.out.println("\n[Login Failed] Invalid email or password.\n");
        return false;
    }

    public K2559495_User addUser(String name, String email, String contact, String type) {
        try {
            String userId = "U" + String.format("%03d", users.size() + 1); // auto ID
            K2559495_User user;

            switch (type.toLowerCase()) {
                case "student":
                    user = new K2559495_Student(userId, name, email, contact, new K2559495_StudentFine());
                    break;
                case "faculty":
                    user = new K2559495_Faculty(userId, name, email, contact, new K2559495_FacultyFine());
                    break;
                case "guest":
                    user = new K2559495_Guest(userId, name, email, contact, new K2559495_GuestFine());
                    break;
                default:
                    System.out.println("[Error] Invalid membership type: " + type);
                    return null;
            }

            users.add(user);
            System.out.println("[User Added] " + user.getName() + " (ID: " + user.getUserId() + ", Type: " + type + ")");
            return user;
        } catch (Exception e) {
            System.out.println("[Error] Failed to add user: " + e.getMessage());
            return null;
        }
    }

    public K2559495_User updateUser(String userId, String newName, String newEmail, String newContact) {
        try {
            for (K2559495_User user : users) {
                if (user.getUserId().equals(userId)) {
                    if (newName != null) {
                        user.setName(newName);
                    }
                    if (newEmail != null) {
                        user.setEmail(newEmail);
                    }
                    if (newContact != null) {
                        user.setContactNumber(newContact);
                    }

                    System.out.println("[User Updated] " + user.getName() + " (ID: " + user.getUserId() + ")");
                    return user;
                }
            }
            System.out.println("[Error] User ID not found: " + userId);
            return null;
        } catch (Exception e) {
            System.out.println("[Error] Failed to update user: " + e.getMessage());
            return null;
        }
    }

    public boolean removeUser(String userId) {
        try {
            for (K2559495_User user : users) {
                if (user.getUserId().equals(userId)) {
                    users.remove(user);
                    System.out.println("[User Removed] ID: " + userId);
                    return true;
                }
            }
            System.out.println("[Error] User ID not found: " + userId);
            return false;
        } catch (Exception e) {
            System.out.println("[Error] Failed to remove user: " + e.getMessage());
            return false;
        }
    }

    // ==================== BOOK DECORATOR METHODS ====================
    public boolean addFeatureToBook(String bookId, String featureType) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return false;
            }

            K2559495_Book book = context.getBook();

            switch (featureType.toLowerCase()) {
                case "featured":
                    book.setFeatured(true);
                    System.out.println("[Feature Added] Featured - " + book.getDescription() + " #Featured");
                    break;
                case "recommended":
                    book.setRecommended(true);
                    System.out.println("[Feature Added] Recommended - " + book.getDescription() + " #Recommended");
                    break;
                case "special edition":
                case "specialedition":
                    book.setSpecialEdition(true);
                    System.out.println("[Feature Added] Special Edition - " + book.getDescription() + " #SpecialEdition");
                    break;
                default:
                    System.out.println("[Error] Invalid feature type: " + featureType);
                    return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("[Error] Failed to add feature: " + e.getMessage());
            return false;
        }
    }

    public boolean removeFeatureFromBook(String bookId, String featureType) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return false;
            }

            K2559495_Book book = context.getBook();

            switch (featureType.toLowerCase()) {
                case "featured":
                    book.setFeatured(false);
                    System.out.println("[Feature Removed] Featured from Book ID: " + bookId);
                    break;
                case "recommended":
                    book.setRecommended(false);
                    System.out.println("[Feature Removed] Recommended from Book ID: " + bookId);
                    break;
                case "special edition":
                case "specialedition":
                    book.setSpecialEdition(false);
                    System.out.println("[Feature Removed] Special Edition from Book ID: " + bookId);
                    break;
                default:
                    System.out.println("[Error] Invalid feature type: " + featureType);
                    return false;
            }

            return true;
        } catch (Exception e) {
            System.out.println("[Error] Failed to remove feature: " + e.getMessage());
            return false;
        }
    }

    public void viewBookById(String bookId) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return;
            }

            context.getBook().displayBookInfo();
        } catch (Exception e) {
            System.out.println("[Error] Failed to view book: " + e.getMessage());
        }
    }

    // ==================== BOOK ENHANCEMENT (TAGS, REVIEWS, EDITION) ====================
    public boolean addTagToBook(String bookId, String tag) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return false;
            }

            context.getBook().addTag(tag);
            System.out.println("[Tag Added] Book ID: " + bookId + " - Tag: " + tag);
            return true;
        } catch (Exception e) {
            System.out.println("[Error] Failed to add tag: " + e.getMessage());
            return false;
        }
    }

    public boolean addReviewToBook(String bookId, String review) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return false;
            }

            context.getBook().addReview(review);
            System.out.println("[Review Added] Book ID: " + bookId);
            return true;
        } catch (Exception e) {
            System.out.println("[Error] Failed to add review: " + e.getMessage());
            return false;
        }
    }

    public boolean setEditionForBook(String bookId, String edition) {
        try {
            K2559495_BookContext context = findBookContextById(bookId);
            if (context == null) {
                System.out.println("[Error] Book ID not found: " + bookId);
                return false;
            }

            context.getBook().updateEdition(edition);
            System.out.println("[Edition Set] Book ID: " + bookId + " - Edition: " + edition);
            return true;
        } catch (Exception e) {
            System.out.println("[Error] Failed to set edition: " + e.getMessage());
            return false;
        }
    }

    // ==================== Helper Methods ====================
    public List<K2559495_BookContext> getBookContexts() {
        return bookContexts;
    }

    public List<K2559495_User> getUsers() {
        return users;
    }

    private K2559495_User findUserById(String userId) {
        for (K2559495_User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private K2559495_BookContext findBookContextById(String bookId) {
        for (K2559495_BookContext context : bookContexts) {
            if (context.getBook().getBookId().equals(bookId)) {
                return context;
            }
        }
        return null;
    }

}
