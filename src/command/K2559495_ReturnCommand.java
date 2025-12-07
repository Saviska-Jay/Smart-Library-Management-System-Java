package command;

import user.abstraction.K2559495_User;
import book.state.K2559495_BookContext;

public class K2559495_ReturnCommand implements K2559495_Command {
    private K2559495_User user;
    private K2559495_BookContext context;

    public K2559495_ReturnCommand(K2559495_User user, K2559495_BookContext context) {
        this.user = user;
        this.context = context;
    }

    @Override
    public void execute() {

        System.out.println("\n:::::::::::::::::::::::::: Return :::::::::::::::::::::::::::");

        context.returnBook(user);

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

    }
}