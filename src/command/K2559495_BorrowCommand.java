package command;

import user.abstraction.K2559495_User;
import book.builder.K2559495_Book;
import book.state.K2559495_BookContext;

public class K2559495_BorrowCommand implements K2559495_Command {

    private K2559495_User user;
    private K2559495_BookContext context;

    public K2559495_BorrowCommand(K2559495_User user, K2559495_BookContext context) {
        this.user = user;
        this.context = context;
    }

    @Override
    public void execute() {

        System.out.println("\n:::::::::::::::::::::::::: Borrow :::::::::::::::::::::::::::");

        context.borrow(user);

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

    }
}
