public class K2559495_BorrowedState implements K2559495_BookState {

    @Override
    public void borrow(K2559495_BookContext context) {
        System.out.println("This book is already borrowed.");
    }

    @Override
    public void returnBook(K2559495_BookContext context) {
        System.out.println("Book returned successfully.");
        context.setState(new K2559495_AvailableState());
    }

    @Override
    public void reserve(K2559495_BookContext context) {
        System.out.println("Cannot reserve a borrowed book.");
        context.setState(new K2559495_ReservedState());
    }

    @Override
    public String getBookStatus() {
        return "Borrowed";
    }
}