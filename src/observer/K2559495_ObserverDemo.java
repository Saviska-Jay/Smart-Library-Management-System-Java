package observer;

import user.abstraction.*;
import user.strategy.K2559495_StudentFine;

public class K2559495_ObserverDemo {
    public static void main(String[] args) {
        K2559495_Student student = new K2559495_Student("S001", "Alice", "Alice@email.com","0712345678", new K2559495_StudentFine());
        K2559495_Observer observer = new K2559495_UserObserver(student);

        K2559495_NotificationService notificationService = new K2559495_NotificationService();
        notificationService.addObserver(observer);

        // Simulate bookk becoming available
        notificationService.notifyObservers("The book 'Design Patterns' is now available.");

    }
}