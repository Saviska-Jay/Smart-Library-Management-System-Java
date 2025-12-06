package command;

import user.abstraction.K2559495_User;
import book.builder.K2559495_Book;
import observer.K2559495_NotificationService;
import observer.K2559495_UserObserver;

public class K2559495_ReserveCommand implements K2559495_Command {
    private K2559495_User user;
    private K2559495_Book book;
    private K2559495_NotificationService notificationService;
    
    public K2559495_ReserveCommand(K2559495_User user, K2559495_Book book, K2559495_NotificationService notificationService) {
        this.user = user;
        this.book = book;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        
        System.out.println("\n:::::::::::::::::::::::::: Reserve ::::::::::::::::::::::::::");
        System.out.println(user.getName() + " has reserved the book: " + book.getTitle());
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
        
        //Register user as an observer for book availability notifications
        notificationService.addObserver(new K2559495_UserObserver(user));
    }
}
