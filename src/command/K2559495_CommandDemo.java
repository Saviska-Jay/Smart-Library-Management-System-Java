package command;

import user.abstraction.*;
import book.builder.*;
import user.strategy.K2559495_StudentFine;
import observer.*;

public class K2559495_CommandDemo {
    public static void main(String[] args) {
        K2559495_Student student = new K2559495_Student("U001", "Saviska", "saviska@email.com", "0712345678", new K2559495_StudentFine() );
        K2559495_Book book = new K2559495_BookBuilder("B001", "Design Patterns", "Gamma", "12345")
                .addCategory("Software Engineering")
                .build();

        K2559495_NotificationService notificationService = new K2559495_NotificationService();
        K2559495_UI ui = new K2559495_UI();

        // Set the command to reserve a book
        ui.setCommand(new K2559495_ReserveCommand(student, book, notificationService));
        ui.pressButton();
        
        // Later simulate availability
        notificationService.notifyObservers("The book 'Design Patterns' is now available.");
    }
}