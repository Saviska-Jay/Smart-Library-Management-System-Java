package book.state;

public class K2559495_ReservedState implements K2559495_BookState {

    @Override
    public void borrow(K2559495_BookContext context) {
        System.out.println("Book is reserved, cannot borrow directly.");
    }

    @Override
    public void returnBook(K2559495_BookContext context) {
        System.out.println("Book returned successfully (was reserved).");
        context.setState(new K2559495_AvailableState());

        // Notify observers that the reserved book is now available
        if (context.getNotificationService() != null) {
            context.getNotificationService().notifyObservers(
                    "The Book '" + context.getBook().getTitle() + "' was reserved and has now been returned. It is available."
            );
            // Clear observers after notification - reservation fulfilled
            context.setNotificationService(null);
        }
    }

    @Override
    public void reserve(K2559495_BookContext context) {
        System.out.println("This book is already reserved.");
    }

    @Override
    public String getBookStatus() {
        return "Reserved";
    }
}
