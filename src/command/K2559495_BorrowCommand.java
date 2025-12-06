package command;

import user.abstraction.K2559495_User;
import book.builder.K2559495_Book;

public class K2559495_BorrowCommand implements K2559495_Command {

    private K2559495_User user;
    private K2559495_Book book;

    public K2559495_BorrowCommand(K2559495_User user, K2559495_Book book) {
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {

        System.out.println("\n:::::::::::::::::::::::::: Borrow :::::::::::::::::::::::::::");

        if (user.getBorrowedBooks().size() < user.getBorrowingLimit()) {
            user.addBorrowedBook(book.getBookId());
            System.out.println(user.getName() + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " has reached the borrowing limit and cannot borrow more books.");
        }

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

    }
}
