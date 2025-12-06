public class K2559495_BookContext {

    private K2559495_BookState currentState;
 
    public K2559495_BookContext(K2559495_BookState state) {
        this.currentState = state;
    }

    public void setState(K2559495_BookState state) {
        this.currentState = state;
    }

    public void borrow() {
        currentState.borrow(this);
    }

    public void returnBook() {
        currentState.returnBook(this);
    }

    public void reserve() {
        currentState.reserve(this);
    }

    public String getBookStatus() {
        return currentState.getBookStatus();
    }
}