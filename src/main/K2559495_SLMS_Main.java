package main;

import book.builder.*;
import book.state.*;
import java.util.Scanner;
import user.abstraction.*;

/**
 * Smart Library Management System - Main Application K2559495 - Saviska
 * Jayawickrama - 2025
 */
public class K2559495_SLMS_Main {

    // ==================== MENU DISPLAY METHODS ====================
    private static void printMainMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                                  Main Menu                                 | \n"
                + " |                                                                            | \n"
                + " |          1. User Management              5. Reserve Book                   | \n"
                + " |          2. Book Management              6. Return Book                    | \n"
                + " |          3. View All Books/Users         7. Enhance Book (Tags/Reviews)    | \n"
                + " |          4. Borrow Book                  8. Exit                           | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    private static void printUserManagementMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                          User Management Menu                              | \n"
                + " |                                                                            | \n"
                + " |          1. Add User                     3. Update User                    | \n"
                + " |          2. Remove User                  4. Back to Main Menu              | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    private static void printBookManagementMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                          Book Management Menu                              | \n"
                + " |                                                                            | \n"
                + " |          1. Add Book                     3. Update Book                    | \n"
                + " |          2. Remove Book                  4. View Book by Id                | \n"
                + " |          5. Back to Main Menu                                              | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    private static void printViewMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                            View Information Menu                           | \n"
                + " |                                                                            | \n"
                + " |          1. View All Books               3. Back to Main Menu              | \n"
                + " |          2. View All Users                                                 | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    private static void printUserTypeMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                          Select User Type                                  | \n"
                + " |                                                                            | \n"
                + " |          1. Student                      3. Guest                          | \n"
                + " |          2. Faculty                                                        | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    private static void printBookEnhancementMenu() {
        String menu
                = "\n"
                + " +============================================================================+\n"
                + " |                       Smart Library Management System                      | \n"
                + " +============================================================================+\n"
                + " |                                                                            | \n"
                + " |                       Book Enhancement Menu                                | \n"
                + " |                                                                            | \n"
                + " |          1. Add Feature to Book          4. Add Review to Book             | \n"
                + " |          2. Set Edition for Book         5. Back to Main Menu              | \n"
                + " |          3. Add Tag to Book                                                | \n"
                + " |                                                                            | \n"
                + " +============================================================================+\n"
                + " |                   K2559495 - Saviska Jayawickrama - 2025                   | \n"
                + " +============================================================================+\n";

        System.out.println(menu);
    }

    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {

        // Initialize Smart Library Management System
        K2559495_Smart_Library_Management_System slms = new K2559495_Smart_Library_Management_System();

        // ==================== DEFAULT DATA INITIALIZATION ====================
        System.out.println("\n[System] Initializing Smart Library Management System...");

        // Add default librarians
        slms.addLibrarian("Kamal Peerera", "kamal@slms.lk", "0771111111", "kamal123");
        slms.addLibrarian("Nimal Herath", "nimal@slms.lk", "0772222222", "nimal123");

        // Add default users
        slms.addUser("John Doe", "john.doe@university.edu", "0771234567", "student");
        slms.addUser("Dr. Jane Smith", "jane.smith@university.edu", "0779876543", "faculty");
        slms.addUser("Mike Wilson", "mike.wilson@gmail.com", "0765555555", "guest");

        // Add default books
        slms.addBook("Design Patterns", "Gang of Four", "Software Engineering", "978-0201633610");
        slms.addBook("Clean Code", "Robert C. Martin", "Programming", "978-0132350884");
        slms.addBook("The Pragmatic Programmer", "Andrew Hunt", "Programming", "978-0201616224");
        slms.addBook("Introduction to Algorithms", "Cormen et al", "Computer Science", "978-0262033848");

        System.out.println("[System] Initialization complete!\n");

        // ==================== INTERACTIVE MENU SYSTEM ====================
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter librarian email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            loggedIn = slms.loginLibrarian(email, password);
        }

        int choice = 0;

        while (choice != 8) {

            printMainMenu();
            System.out.print("Enter your choice (1-8): ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("[Error] Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                // ==================== USER MANAGEMENT ====================
                case 1:
                    int userChoice = 0;
                    while (userChoice != 4) {
                        printUserManagementMenu();
                        System.out.print("Enter your choice (1-4): ");

                        try {
                            userChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("[Error] Invalid input. Please enter a number between 1 and 4.");
                            scanner.nextLine();
                            continue;
                        }

                        switch (userChoice) {
                            case 1: // Add User
                                System.out.println("\n+============================================+");
                                System.out.println("|         Add New User to System             |");
                                System.out.println("|       Please fill in the details           |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Name: ");
                                String userName = scanner.nextLine();
                                System.out.print(" Email: ");
                                String userEmail = scanner.nextLine();
                                System.out.print(" Contact Number: ");
                                String userContact = scanner.nextLine();

                                printUserTypeMenu();
                                System.out.print("Select user type (1-3): ");
                                int typeChoice = scanner.nextInt();
                                scanner.nextLine();

                                String userType = "";
                                switch (typeChoice) {
                                    case 1:
                                        userType = "student";
                                        break;
                                    case 2:
                                        userType = "faculty";
                                        break;
                                    case 3:
                                        userType = "guest";
                                        break;
                                    default:
                                        System.out.println("[Error] Invalid user type selected.");
                                        continue;
                                }

                                K2559495_User newUser = slms.addUser(userName, userEmail, userContact, userType);
                                if (newUser != null) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|        User Added Successfully!            |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 2: // Remove User
                                System.out.println("\n+============================================+");
                                System.out.println("|            Remove User from System         |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter User ID to remove: ");
                                String removeUserId = scanner.nextLine();

                                boolean userRemoved = slms.removeUser(removeUserId);
                                if (userRemoved) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       User Removed Successfully!           |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 3: // Update User
                                System.out.println("\n+============================================+");
                                System.out.println("|              Update User Details           |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter User ID to update: ");
                                String updateUserId = scanner.nextLine();

                                System.out.print(" New Name (press Enter to skip): ");
                                String newName = scanner.nextLine();
                                System.out.print(" New Email (press Enter to skip): ");
                                String newEmail = scanner.nextLine();
                                System.out.print(" New Contact (press Enter to skip): ");
                                String newContact = scanner.nextLine();

                                K2559495_User updatedUser = slms.updateUser(
                                        updateUserId,
                                        newName.isEmpty() ? null : newName,
                                        newEmail.isEmpty() ? null : newEmail,
                                        newContact.isEmpty() ? null : newContact
                                );

                                if (updatedUser != null) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       User Updated Successfully!           |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 4: // Back to Main Menu
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("[Error] Invalid choice. Please try again.");
                        }
                    }
                    break;

                // ==================== BOOK MANAGEMENT ====================
                case 2:
                    int bookChoice = 0;
                    while (bookChoice != 5) {
                        printBookManagementMenu();
                        System.out.print("Enter your choice (1-5): ");

                        try {
                            bookChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("[Error] Invalid input. Please enter a number between 1 and 5.");
                            scanner.nextLine();
                            continue;
                        }

                        switch (bookChoice) {
                            case 1: // Add Book
                                System.out.println("\n+============================================+");
                                System.out.println("|         Add New Book to Library            |");
                                System.out.println("|       Please fill in the details           |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Title: ");
                                String bookTitle = scanner.nextLine();
                                System.out.print(" Author: ");
                                String bookAuthor = scanner.nextLine();
                                System.out.print(" Category: ");
                                String bookCategory = scanner.nextLine();
                                System.out.print(" ISBN: ");
                                String bookIsbn = scanner.nextLine();

                                K2559495_Book newBook = slms.addBook(bookTitle, bookAuthor, bookCategory, bookIsbn);
                                if (newBook != null) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|        Book Added Successfully!            |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 2: // Remove Book
                                System.out.println("\n+============================================+");
                                System.out.println("|          Remove Book from Library          |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID to remove: ");
                                String removeBookId = scanner.nextLine();

                                boolean bookRemoved = slms.removeBook(removeBookId);
                                if (bookRemoved) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       Book Removed Successfully!           |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 3: // Update Book
                                System.out.println("\n+============================================+");
                                System.out.println("|              Update Book Details           |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID to update: ");
                                String updateBookId = scanner.nextLine();

                                System.out.print(" New Title (press Enter to skip): ");
                                String newTitle = scanner.nextLine();
                                System.out.print(" New Author (press Enter to skip): ");
                                String newAuthor = scanner.nextLine();
                                System.out.print(" New Category (press Enter to skip): ");
                                String newCategory = scanner.nextLine();
                                System.out.print(" New ISBN (press Enter to skip): ");
                                String newIsbn = scanner.nextLine();

                                K2559495_Book updatedBook = slms.updateBook(
                                        updateBookId,
                                        newTitle.isEmpty() ? null : newTitle,
                                        newAuthor.isEmpty() ? null : newAuthor,
                                        newCategory.isEmpty() ? null : newCategory,
                                        newIsbn.isEmpty() ? null : newIsbn
                                );

                                if (updatedBook != null) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       Book Updated Successfully!           |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 4: // View Book by ID
                                System.out.println("\n+============================================+");
                                System.out.println("|            View Book by ID                 |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID: ");
                                String viewBookId = scanner.nextLine();

                                slms.viewBookById(viewBookId);
                                break;

                            case 5: // Back to Main Menu
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("[Error] Invalid choice. Please try again.");
                        }
                    }
                    break;

                // ==================== VIEW ALL BOOKS/USERS ====================
                case 3:
                    int viewChoice = 0;
                    while (viewChoice != 3) {
                        printViewMenu();
                        System.out.print("Enter your choice (1-3): ");

                        try {
                            viewChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("[Error] Invalid input. Please enter a number between 1 and 3.");
                            scanner.nextLine();
                            continue;
                        }

                        switch (viewChoice) {
                            case 1: // View All Books
                                System.out.println("\n+============================================================================+");
                                System.out.println("|                            ALL BOOKS IN LIBRARY                            |");
                                System.out.println("+============================================================================+\n");

                                if (slms.getBookContexts().isEmpty()) {
                                    System.out.println(" No books available in the library.\n");
                                } else {
                                    for (K2559495_BookContext context : slms.getBookContexts()) {
                                        K2559495_Book book = context.getBook();
                                        book.displayBookInfo();
                                    }
                                }
                                System.out.println("+============================================================================+\n");
                                break;

                            case 2: // View All Users
                                System.out.println("\n+============================================================================+");
                                System.out.println("|                           ALL REGISTERED USERS                             |");
                                System.out.println("+============================================================================+\n");

                                if (slms.getUsers().isEmpty()) {
                                    System.out.println(" No users registered in the system.\n");
                                } else {
                                    for (K2559495_User user : slms.getUsers()) {
                                        System.out.println(" User ID     : " + user.getUserId());
                                        System.out.println(" Name        : " + user.getName());
                                        System.out.println(" Email       : " + user.getEmail());
                                        System.out.println(" Contact     : " + user.getContactNumber());
                                        System.out.println(" Type        : " + user.getClass().getSimpleName().replace("K2559495_", ""));
                                        System.out.println(" --------------------------------------------------------");
                                    }
                                }
                                System.out.println("+============================================================================+\n");
                                break;

                            case 3: // Back to Main Menu
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("[Error] Invalid choice. Please try again.");
                        }
                    }
                    break;

                // ==================== BORROW BOOK ====================
                case 4:
                    System.out.println("\n+============================================+");
                    System.out.println("|              Borrow Book                   |");
                    System.out.println("+============================================+\n");

                    System.out.print(" Enter User ID: ");
                    String borrowUserId = scanner.nextLine();
                    System.out.print(" Enter Book ID: ");
                    String borrowBookId = scanner.nextLine();

                    slms.borrowBook(borrowUserId, borrowBookId);
                    System.out.println("\n+============================================+\n");
                    break;

                // ==================== RESERVE BOOK ====================
                case 5:
                    System.out.println("\n+============================================+");
                    System.out.println("|              Reserve Book                  |");
                    System.out.println("+============================================+\n");

                    System.out.print(" Enter User ID: ");
                    String reserveUserId = scanner.nextLine();
                    System.out.print(" Enter Book ID: ");
                    String reserveBookId = scanner.nextLine();

                    slms.reserveBook(reserveUserId, reserveBookId);
                    System.out.println("\n+============================================+\n");
                    break;

                // ==================== RETURN BOOK ====================
                case 6:
                    System.out.println("\n+============================================+");
                    System.out.println("|              Return Book                   |");
                    System.out.println("+============================================+\n");

                    System.out.print(" Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print(" Enter Book ID: ");
                    String returnBookId = scanner.nextLine();

                    slms.returnBook(returnUserId, returnBookId);
                    System.out.println("\n+============================================+\n");
                    break;

                // ==================== ENHANCE BOOK (DECORATORS, EDITION, TAGS, REVIEWS) ====================
                case 7:
                    int enhanceChoice = 0;
                    while (enhanceChoice != 5) {
                        printBookEnhancementMenu();
                        System.out.print("Enter your choice (1-5): ");

                        try {
                            enhanceChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("[Error] Invalid input. Please enter a number between 1 and 5.");
                            scanner.nextLine();
                            continue;
                        }

                        switch (enhanceChoice) {
                            case 1: // Add Feature to Book
                                System.out.println("\n+============================================+");
                                System.out.println("|        Add Feature to Book                 |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID: ");
                                String featureBookId = scanner.nextLine();

                                System.out.println("\n Available Features:");
                                System.out.println(" 1. Featured");
                                System.out.println(" 2. Recommended");
                                System.out.println(" 3. Special Edition");
                                System.out.print("\n Select feature to add (1-3): ");

                                int featureType = scanner.nextInt();
                                scanner.nextLine();

                                String feature = "";
                                switch (featureType) {
                                    case 1:
                                        feature = "featured";
                                        break;
                                    case 2:
                                        feature = "recommended";
                                        break;
                                    case 3:
                                        feature = "special edition";
                                        break;
                                    default:
                                        System.out.println("[Error] Invalid feature selection.");
                                        continue;
                                }

                                boolean featureAdded = slms.addFeatureToBook(featureBookId, feature);
                                if (featureAdded) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       Feature Added Successfully!          |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 2: // Set Edition for Book
                                System.out.println("\n+============================================+");
                                System.out.println("|        Set Edition for Book                |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID: ");
                                String editionBookId = scanner.nextLine();
                                System.out.print(" Enter Edition (e.g., 1st Edition, 2nd Edition): ");
                                String edition = scanner.nextLine();

                                boolean editionSet = slms.setEditionForBook(editionBookId, edition);
                                if (editionSet) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       Edition Set Successfully!            |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 3: // Add Tag to Book
                                System.out.println("\n+============================================+");
                                System.out.println("|            Add Tag to Book                 |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID: ");
                                String tagBookId = scanner.nextLine();
                                System.out.print(" Enter Tag (e.g., Bestseller, Classic): ");
                                String tag = scanner.nextLine();

                                boolean tagAdded = slms.addTagToBook(tagBookId, tag);
                                if (tagAdded) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|         Tag Added Successfully!            |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 4: // Add Review to Book
                                System.out.println("\n+============================================+");
                                System.out.println("|          Add Review to Book                |");
                                System.out.println("+============================================+\n");

                                System.out.print(" Enter Book ID: ");
                                String reviewBookId = scanner.nextLine();
                                System.out.print(" Enter Review: ");
                                String review = scanner.nextLine();

                                boolean reviewAdded = slms.addReviewToBook(reviewBookId, review);
                                if (reviewAdded) {
                                    System.out.println("\n+============================================+");
                                    System.out.println("|       Review Added Successfully!           |");
                                    System.out.println("+============================================+\n");
                                }
                                break;

                            case 5: // Back to Main Menu
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("[Error] Invalid choice. Please try again.");
                        }
                    }
                    break;

                // ==================== EXIT ====================
                case 8:
                    System.out.println("\n+============================================+");
                    System.out.println("|         Thank you for using SLMS!          |");
                    System.out.println("|              Exiting system...             |");
                    System.out.println("+============================================+\n");
                    break;

                default:
                    System.out.println("[Error] Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
