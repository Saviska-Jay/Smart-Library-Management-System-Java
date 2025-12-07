package book.reports;

import book.state.K2559495_BookContext;
import java.util.*;

public class K2559495_MostBorrowedBooksReport {

    public static void generate(List<K2559495_BookContext> bookContexts, int topN) {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::: Most Borrowed Books Report ::::::::::::::::::::");
        System.out.println("---------------------------------------------------------------");
        bookContexts.stream()
                .sorted((b1, b2) -> Integer.compare(
                b2.getBorrowedHistory().size(), b1.getBorrowedHistory().size()))
                .limit(topN)
                .forEach(context -> {
                    System.out.println("Book: " + context.getBook().getTitle());
                    System.out.println("Borrow Count: " + context.getBorrowedHistory().size());
                    System.out.println("---------------------------------------------------------------");
                });

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }
}
