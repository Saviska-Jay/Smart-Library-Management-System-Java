public class K2559495_AvailableState implements K2559495_BookState{
    @Override
    public void borrow(K2559495_BookContext context) {
        System.out.println("Book borrowed successfully.");
        context.setState(new K2559495_BorrowedState());
    }

    @Override
    public void returnBook(K2559495_BookContext context) {
        System.out.println("This book is already available in the library.");
    }

    @Override
    public void reserve(K2559495_BookContext context) {
        System.out.println("Book reserved successfully.");
        context.setState(new K2559495_ReservedState());
    }
    
    @Override
    public String getBookStatus() {
        return "Available";
    }
}