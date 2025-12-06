package command;

import user.abstraction.K2559495_User;
import book.builder.K2559495_Book;

public class K2559495_ReturnCommand implements K2559495_Command {

    private K2559495_User user;
    private K2559495_Book book;

    public K2559495_ReturnCommand(K2559495_User user, K2559495_Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {

        System.out.println("\n:::::::::::::::::::::::::: Return :::::::::::::::::::::::::::");
    
        if (user.getBorrowedBooks().contains(book.getBookId())) {
            user.getBorrowedBooks().remove(book.getBookId());
            System.out.println(user.getName() + " has returned the book: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " has not borrowed the book: " + book.getTitle());
        }

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

    }
}
