public class K2559495_ReservedState implements K2559495_BookState {
    
    @Override
    public void borrow(K2559495_BookContext context) {
        System.out.println("Book is reserved, cannot borrow directly.");
    }

    @Override
    public void returnBook(K2559495_BookContext context) {
        System.out.println("Cannot return a reserved book that is not borrowed.");
        context.setState(new K2559495_AvailableState());
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
