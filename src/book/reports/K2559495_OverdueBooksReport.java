package book.reports;

import book.state.K2559495_BookContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class K2559495_OverdueBooksReport {

    public static void generate(List<K2559495_BookContext> bookContexts) {
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::: Overdue Books Report ::::::::::::::::::::::::::");
        System.out.println("---------------------------------------------------------------");
        for (K2559495_BookContext context : bookContexts) {
            LocalDate dueDate = context.getDueDate();
            if (dueDate != null && LocalDate.now().isAfter(dueDate)) {
                long overdueDays = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
                System.out.println("Book: " + context.getBook().getTitle());
                System.out.println("Overdue by: " + overdueDays + " days");
                System.out.println("---------------------------------------------------------------");
            }
        }

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
    }
}
