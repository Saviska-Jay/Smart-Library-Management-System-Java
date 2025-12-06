public class K2559495_BookStateDemo {
    public static void main(String[] args) {
        K2559495_BookContext book = new K2559495_BookContext(new K2559495_AvailableState());

        System.out.println("Initial Book Status: " + book.getBookStatus());

        book.borrow();
        System.out.println("Book Status after borrowing: " + book.getBookStatus());

        book.reserve();
        System.out.println("Book Status after reserving: " + book.getBookStatus());

        book.returnBook();
        System.out.println("Book Status after returning: " + book.getBookStatus());
    }
}
