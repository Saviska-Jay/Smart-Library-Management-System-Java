public class K2559495_BookDecoratorDemo {
    public static void main(String[] args) {
        K2559495_BookFeature book = () -> "The Great Gatsby by F. Scott Fitzgerald";

        // Adding features using decorators
        book = new K2559495_RecommendedBook(book);
        book = new K2559495_FeaturedBook(book);
        book = new K2559495_SpecialEditionBook(book);

        System.out.println("Book Description: " + book.getDescription());
    }
}