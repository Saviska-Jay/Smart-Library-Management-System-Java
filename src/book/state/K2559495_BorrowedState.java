package book.state;

public class K2559495_BorrowedState implements K2559495_BookState {

    @Override
    public void borrow(K2559495_BookContext context) {
        System.out.println("This book is already borrowed.");
    }

    @Override
    public void returnBook(K2559495_BookContext context) {
        System.out.println("Book returned successfully.");
        context.setState(new K2559495_AvailableState());

        // Notify observers that the book is now available
        if (context.getNotificationService() != null) {
            context.getNotificationService().notifyObservers(
                    "The Book '" + context.getBook().getTitle() + "' has been returned and is now available."
            );
            // Clear observers after notification - reservation fulfilled
            context.setNotificationService(null);
        }
    }

    @Override
    public void reserve(K2559495_BookContext context) {
        System.out.println("Book reserved successfully.");
        context.setState(new K2559495_ReservedState());
    }

    @Override
    public String getBookStatus() {
        return "Borrowed";
    }
}
