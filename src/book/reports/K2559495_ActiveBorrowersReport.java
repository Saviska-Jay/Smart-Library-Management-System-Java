package book.reports;

import user.abstraction.K2559495_User;
import java.util.*;

public class K2559495_ActiveBorrowersReport {

    public static void generate(List<K2559495_User> users, int topN) {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::: Active Borrowers Report :::::::::::::::::::::::");
        System.out.println("---------------------------------------------------------------");
        users.stream()
                .sorted((u1, u2) -> Integer.compare(
                u2.getBorrowedBooks().size(), u1.getBorrowedBooks().size()))
                .limit(topN)
                .forEach(user -> {
                    System.out.println("User: " + user.getName());
                    System.out.println("Borrowed Books Count: " + user.getBorrowedBooks().size());
                    System.out.println("---------------------------------------------------------------");
                });

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }
}
