public interface K2559495_BookState {
    void borrow(K2559495_BookContext context);
    void returnBook(K2559495_BookContext context);
    void reserve(K2559495_BookContext context);
    String getBookStatus();
}